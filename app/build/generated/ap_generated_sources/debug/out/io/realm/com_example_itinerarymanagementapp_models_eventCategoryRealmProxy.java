package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_itinerarymanagementapp_models_eventCategoryRealmProxy extends com.example.itinerarymanagementapp.models.eventCategory
    implements RealmObjectProxy, com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface {

    static final class eventCategoryColumnInfo extends ColumnInfo {
        long uuidColKey;
        long nameColKey;

        eventCategoryColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("eventCategory");
            this.uuidColKey = addColumnDetails("uuid", "uuid", objectSchemaInfo);
            this.nameColKey = addColumnDetails("name", "name", objectSchemaInfo);
        }

        eventCategoryColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new eventCategoryColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final eventCategoryColumnInfo src = (eventCategoryColumnInfo) rawSrc;
            final eventCategoryColumnInfo dst = (eventCategoryColumnInfo) rawDst;
            dst.uuidColKey = src.uuidColKey;
            dst.nameColKey = src.nameColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private eventCategoryColumnInfo columnInfo;
    private ProxyState<com.example.itinerarymanagementapp.models.eventCategory> proxyState;

    com_example_itinerarymanagementapp_models_eventCategoryRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (eventCategoryColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.itinerarymanagementapp.models.eventCategory>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uuid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uuidColKey);
    }

    @Override
    public void realmSet$uuid(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'uuid' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameColKey);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "eventCategory", false, 2, 0);
        builder.addPersistedProperty(NO_ALIAS, "uuid", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static eventCategoryColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new eventCategoryColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "eventCategory";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "eventCategory";
    }

    @SuppressWarnings("cast")
    public static com.example.itinerarymanagementapp.models.eventCategory createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.itinerarymanagementapp.models.eventCategory obj = null;
        if (update) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
            eventCategoryColumnInfo columnInfo = (eventCategoryColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class);
            long pkColumnKey = columnInfo.uuidColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("uuid")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("uuid"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uuid")) {
                if (json.isNull("uuid")) {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.eventCategory.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.eventCategory.class, json.getString("uuid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uuid'.");
            }
        }

        final com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) obj;
        if (json.has("name")) {
            if (json.isNull("name")) {
                objProxy.realmSet$name(null);
            } else {
                objProxy.realmSet$name((String) json.getString("name"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.itinerarymanagementapp.models.eventCategory createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.itinerarymanagementapp.models.eventCategory obj = new com.example.itinerarymanagementapp.models.eventCategory();
        final com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("uuid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uuid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uuid(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$name((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$name(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uuid'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_example_itinerarymanagementapp_models_eventCategoryRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class), false, Collections.<String>emptyList());
        io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy obj = new io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.itinerarymanagementapp.models.eventCategory copyOrUpdate(Realm realm, eventCategoryColumnInfo columnInfo, com.example.itinerarymanagementapp.models.eventCategory object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.itinerarymanagementapp.models.eventCategory) cachedRealmObject;
        }

        com.example.itinerarymanagementapp.models.eventCategory realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
            long pkColumnKey = columnInfo.uuidColKey;
            String value = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$uuid();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.itinerarymanagementapp.models.eventCategory copy(Realm realm, eventCategoryColumnInfo columnInfo, com.example.itinerarymanagementapp.models.eventCategory newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.itinerarymanagementapp.models.eventCategory) cachedRealmObject;
        }

        com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface unmanagedSource = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.uuidColKey, unmanagedSource.realmGet$uuid());
        builder.addString(columnInfo.nameColKey, unmanagedSource.realmGet$name());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_itinerarymanagementapp_models_eventCategoryRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.itinerarymanagementapp.models.eventCategory object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        long tableNativePtr = table.getNativePtr();
        eventCategoryColumnInfo columnInfo = (eventCategoryColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$uuid();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        long tableNativePtr = table.getNativePtr();
        eventCategoryColumnInfo columnInfo = (eventCategoryColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.eventCategory object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.eventCategory) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$uuid();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.itinerarymanagementapp.models.eventCategory object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        long tableNativePtr = table.getNativePtr();
        eventCategoryColumnInfo columnInfo = (eventCategoryColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$uuid();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$name = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        long tableNativePtr = table.getNativePtr();
        eventCategoryColumnInfo columnInfo = (eventCategoryColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.eventCategory.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.eventCategory object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.eventCategory) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$uuid();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$name = ((com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) object).realmGet$name();
            if (realmGet$name != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nameColKey, objKey, realmGet$name, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nameColKey, objKey, false);
            }
        }
    }

    public static com.example.itinerarymanagementapp.models.eventCategory createDetachedCopy(com.example.itinerarymanagementapp.models.eventCategory realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.itinerarymanagementapp.models.eventCategory unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.itinerarymanagementapp.models.eventCategory();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.itinerarymanagementapp.models.eventCategory) cachedObject.object;
            }
            unmanagedObject = (com.example.itinerarymanagementapp.models.eventCategory) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface unmanagedCopy = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) unmanagedObject;
        com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface realmSource = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$uuid(realmSource.realmGet$uuid());
        unmanagedCopy.realmSet$name(realmSource.realmGet$name());

        return unmanagedObject;
    }

    static com.example.itinerarymanagementapp.models.eventCategory update(Realm realm, eventCategoryColumnInfo columnInfo, com.example.itinerarymanagementapp.models.eventCategory realmObject, com.example.itinerarymanagementapp.models.eventCategory newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface realmObjectTarget = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) realmObject;
        com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface realmObjectSource = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.eventCategory.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.uuidColKey, realmObjectSource.realmGet$uuid());
        builder.addString(columnInfo.nameColKey, realmObjectSource.realmGet$name());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("eventCategory = proxy[");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_itinerarymanagementapp_models_eventCategoryRealmProxy aeventCategory = (com_example_itinerarymanagementapp_models_eventCategoryRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aeventCategory.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aeventCategory.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aeventCategory.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
