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
public class com_example_itinerarymanagementapp_models_TripRealmProxy extends com.example.itinerarymanagementapp.models.Trip
    implements RealmObjectProxy, com_example_itinerarymanagementapp_models_TripRealmProxyInterface {

    static final class TripColumnInfo extends ColumnInfo {
        long uuidColKey;
        long userUUIDColKey;
        long categoryColKey;
        long tripNameColKey;
        long descriptionColKey;

        TripColumnInfo(OsSchemaInfo schemaInfo) {
            super(5);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Trip");
            this.uuidColKey = addColumnDetails("uuid", "uuid", objectSchemaInfo);
            this.userUUIDColKey = addColumnDetails("userUUID", "userUUID", objectSchemaInfo);
            this.categoryColKey = addColumnDetails("category", "category", objectSchemaInfo);
            this.tripNameColKey = addColumnDetails("tripName", "tripName", objectSchemaInfo);
            this.descriptionColKey = addColumnDetails("description", "description", objectSchemaInfo);
        }

        TripColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TripColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TripColumnInfo src = (TripColumnInfo) rawSrc;
            final TripColumnInfo dst = (TripColumnInfo) rawDst;
            dst.uuidColKey = src.uuidColKey;
            dst.userUUIDColKey = src.userUUIDColKey;
            dst.categoryColKey = src.categoryColKey;
            dst.tripNameColKey = src.tripNameColKey;
            dst.descriptionColKey = src.descriptionColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TripColumnInfo columnInfo;
    private ProxyState<com.example.itinerarymanagementapp.models.Trip> proxyState;

    com_example_itinerarymanagementapp_models_TripRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TripColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.itinerarymanagementapp.models.Trip>(this);
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
    public String realmGet$userUUID() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userUUIDColKey);
    }

    @Override
    public void realmSet$userUUID(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userUUIDColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.userUUIDColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userUUIDColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userUUIDColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$category() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.categoryColKey);
    }

    @Override
    public void realmSet$category(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.categoryColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.categoryColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.categoryColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.categoryColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$tripName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tripNameColKey);
    }

    @Override
    public void realmSet$tripName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tripNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.tripNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tripNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tripNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$description() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descriptionColKey);
    }

    @Override
    public void realmSet$description(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descriptionColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.descriptionColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descriptionColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descriptionColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Trip", false, 5, 0);
        builder.addPersistedProperty(NO_ALIAS, "uuid", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "userUUID", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "category", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "tripName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "description", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TripColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TripColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Trip";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Trip";
    }

    @SuppressWarnings("cast")
    public static com.example.itinerarymanagementapp.models.Trip createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.itinerarymanagementapp.models.Trip obj = null;
        if (update) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
            TripColumnInfo columnInfo = (TripColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class);
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
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uuid")) {
                if (json.isNull("uuid")) {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.Trip.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.Trip.class, json.getString("uuid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uuid'.");
            }
        }

        final com_example_itinerarymanagementapp_models_TripRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) obj;
        if (json.has("userUUID")) {
            if (json.isNull("userUUID")) {
                objProxy.realmSet$userUUID(null);
            } else {
                objProxy.realmSet$userUUID((String) json.getString("userUUID"));
            }
        }
        if (json.has("category")) {
            if (json.isNull("category")) {
                objProxy.realmSet$category(null);
            } else {
                objProxy.realmSet$category((String) json.getString("category"));
            }
        }
        if (json.has("tripName")) {
            if (json.isNull("tripName")) {
                objProxy.realmSet$tripName(null);
            } else {
                objProxy.realmSet$tripName((String) json.getString("tripName"));
            }
        }
        if (json.has("description")) {
            if (json.isNull("description")) {
                objProxy.realmSet$description(null);
            } else {
                objProxy.realmSet$description((String) json.getString("description"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.itinerarymanagementapp.models.Trip createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.itinerarymanagementapp.models.Trip obj = new com.example.itinerarymanagementapp.models.Trip();
        final com_example_itinerarymanagementapp_models_TripRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) obj;
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
            } else if (name.equals("userUUID")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$userUUID((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$userUUID(null);
                }
            } else if (name.equals("category")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$category((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$category(null);
                }
            } else if (name.equals("tripName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tripName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tripName(null);
                }
            } else if (name.equals("description")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$description((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$description(null);
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

    static com_example_itinerarymanagementapp_models_TripRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class), false, Collections.<String>emptyList());
        io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy obj = new io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.itinerarymanagementapp.models.Trip copyOrUpdate(Realm realm, TripColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Trip object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.itinerarymanagementapp.models.Trip) cachedRealmObject;
        }

        com.example.itinerarymanagementapp.models.Trip realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
            long pkColumnKey = columnInfo.uuidColKey;
            String value = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$uuid();
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
                    realmObject = new io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.itinerarymanagementapp.models.Trip copy(Realm realm, TripColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Trip newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.itinerarymanagementapp.models.Trip) cachedRealmObject;
        }

        com_example_itinerarymanagementapp_models_TripRealmProxyInterface unmanagedSource = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.uuidColKey, unmanagedSource.realmGet$uuid());
        builder.addString(columnInfo.userUUIDColKey, unmanagedSource.realmGet$userUUID());
        builder.addString(columnInfo.categoryColKey, unmanagedSource.realmGet$category());
        builder.addString(columnInfo.tripNameColKey, unmanagedSource.realmGet$tripName());
        builder.addString(columnInfo.descriptionColKey, unmanagedSource.realmGet$description());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_itinerarymanagementapp_models_TripRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.itinerarymanagementapp.models.Trip object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        long tableNativePtr = table.getNativePtr();
        TripColumnInfo columnInfo = (TripColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$userUUID = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$userUUID();
        if (realmGet$userUUID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userUUIDColKey, objKey, realmGet$userUUID, false);
        }
        String realmGet$category = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
        }
        String realmGet$tripName = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$tripName();
        if (realmGet$tripName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripNameColKey, objKey, realmGet$tripName, false);
        }
        String realmGet$description = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        long tableNativePtr = table.getNativePtr();
        TripColumnInfo columnInfo = (TripColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.Trip object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.Trip) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$userUUID = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$userUUID();
            if (realmGet$userUUID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userUUIDColKey, objKey, realmGet$userUUID, false);
            }
            String realmGet$category = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
            }
            String realmGet$tripName = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$tripName();
            if (realmGet$tripName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripNameColKey, objKey, realmGet$tripName, false);
            }
            String realmGet$description = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.itinerarymanagementapp.models.Trip object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        long tableNativePtr = table.getNativePtr();
        TripColumnInfo columnInfo = (TripColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$userUUID = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$userUUID();
        if (realmGet$userUUID != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userUUIDColKey, objKey, realmGet$userUUID, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userUUIDColKey, objKey, false);
        }
        String realmGet$category = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.categoryColKey, objKey, false);
        }
        String realmGet$tripName = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$tripName();
        if (realmGet$tripName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripNameColKey, objKey, realmGet$tripName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tripNameColKey, objKey, false);
        }
        String realmGet$description = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$description();
        if (realmGet$description != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descriptionColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        long tableNativePtr = table.getNativePtr();
        TripColumnInfo columnInfo = (TripColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Trip.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.Trip object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.Trip) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$userUUID = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$userUUID();
            if (realmGet$userUUID != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.userUUIDColKey, objKey, realmGet$userUUID, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.userUUIDColKey, objKey, false);
            }
            String realmGet$category = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.categoryColKey, objKey, false);
            }
            String realmGet$tripName = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$tripName();
            if (realmGet$tripName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripNameColKey, objKey, realmGet$tripName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tripNameColKey, objKey, false);
            }
            String realmGet$description = ((com_example_itinerarymanagementapp_models_TripRealmProxyInterface) object).realmGet$description();
            if (realmGet$description != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descriptionColKey, objKey, realmGet$description, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descriptionColKey, objKey, false);
            }
        }
    }

    public static com.example.itinerarymanagementapp.models.Trip createDetachedCopy(com.example.itinerarymanagementapp.models.Trip realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.itinerarymanagementapp.models.Trip unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.itinerarymanagementapp.models.Trip();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.itinerarymanagementapp.models.Trip) cachedObject.object;
            }
            unmanagedObject = (com.example.itinerarymanagementapp.models.Trip) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_itinerarymanagementapp_models_TripRealmProxyInterface unmanagedCopy = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) unmanagedObject;
        com_example_itinerarymanagementapp_models_TripRealmProxyInterface realmSource = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$uuid(realmSource.realmGet$uuid());
        unmanagedCopy.realmSet$userUUID(realmSource.realmGet$userUUID());
        unmanagedCopy.realmSet$category(realmSource.realmGet$category());
        unmanagedCopy.realmSet$tripName(realmSource.realmGet$tripName());
        unmanagedCopy.realmSet$description(realmSource.realmGet$description());

        return unmanagedObject;
    }

    static com.example.itinerarymanagementapp.models.Trip update(Realm realm, TripColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Trip realmObject, com.example.itinerarymanagementapp.models.Trip newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_itinerarymanagementapp_models_TripRealmProxyInterface realmObjectTarget = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) realmObject;
        com_example_itinerarymanagementapp_models_TripRealmProxyInterface realmObjectSource = (com_example_itinerarymanagementapp_models_TripRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Trip.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.uuidColKey, realmObjectSource.realmGet$uuid());
        builder.addString(columnInfo.userUUIDColKey, realmObjectSource.realmGet$userUUID());
        builder.addString(columnInfo.categoryColKey, realmObjectSource.realmGet$category());
        builder.addString(columnInfo.tripNameColKey, realmObjectSource.realmGet$tripName());
        builder.addString(columnInfo.descriptionColKey, realmObjectSource.realmGet$description());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Trip = proxy[");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{userUUID:");
        stringBuilder.append(realmGet$userUUID() != null ? realmGet$userUUID() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{category:");
        stringBuilder.append(realmGet$category() != null ? realmGet$category() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tripName:");
        stringBuilder.append(realmGet$tripName() != null ? realmGet$tripName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{description:");
        stringBuilder.append(realmGet$description() != null ? realmGet$description() : "null");
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
        com_example_itinerarymanagementapp_models_TripRealmProxy aTrip = (com_example_itinerarymanagementapp_models_TripRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aTrip.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTrip.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aTrip.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
