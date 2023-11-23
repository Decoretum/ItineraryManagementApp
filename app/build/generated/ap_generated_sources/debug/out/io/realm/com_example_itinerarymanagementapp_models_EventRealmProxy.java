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
public class com_example_itinerarymanagementapp_models_EventRealmProxy extends com.example.itinerarymanagementapp.models.Event
    implements RealmObjectProxy, com_example_itinerarymanagementapp_models_EventRealmProxyInterface {

    static final class EventColumnInfo extends ColumnInfo {
        long uuidColKey;
        long categoryColKey;
        long tripNameReferenceColKey;
        long eventNameColKey;
        long eventDescriptionColKey;
        long timeRangeColKey;

        EventColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Event");
            this.uuidColKey = addColumnDetails("uuid", "uuid", objectSchemaInfo);
            this.categoryColKey = addColumnDetails("category", "category", objectSchemaInfo);
            this.tripNameReferenceColKey = addColumnDetails("tripNameReference", "tripNameReference", objectSchemaInfo);
            this.eventNameColKey = addColumnDetails("eventName", "eventName", objectSchemaInfo);
            this.eventDescriptionColKey = addColumnDetails("eventDescription", "eventDescription", objectSchemaInfo);
            this.timeRangeColKey = addColumnDetails("timeRange", "timeRange", objectSchemaInfo);
        }

        EventColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new EventColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final EventColumnInfo src = (EventColumnInfo) rawSrc;
            final EventColumnInfo dst = (EventColumnInfo) rawDst;
            dst.uuidColKey = src.uuidColKey;
            dst.categoryColKey = src.categoryColKey;
            dst.tripNameReferenceColKey = src.tripNameReferenceColKey;
            dst.eventNameColKey = src.eventNameColKey;
            dst.eventDescriptionColKey = src.eventDescriptionColKey;
            dst.timeRangeColKey = src.timeRangeColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private EventColumnInfo columnInfo;
    private ProxyState<com.example.itinerarymanagementapp.models.Event> proxyState;

    com_example_itinerarymanagementapp_models_EventRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (EventColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.itinerarymanagementapp.models.Event>(this);
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
    public String realmGet$tripNameReference() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tripNameReferenceColKey);
    }

    @Override
    public void realmSet$tripNameReference(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tripNameReferenceColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.tripNameReferenceColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tripNameReferenceColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tripNameReferenceColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$eventName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventNameColKey);
    }

    @Override
    public void realmSet$eventName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$eventDescription() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.eventDescriptionColKey);
    }

    @Override
    public void realmSet$eventDescription(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.eventDescriptionColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.eventDescriptionColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.eventDescriptionColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.eventDescriptionColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$timeRange() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.timeRangeColKey);
    }

    @Override
    public void realmSet$timeRange(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.timeRangeColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.timeRangeColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.timeRangeColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.timeRangeColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "Event", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "uuid", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "category", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "tripNameReference", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "eventName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "eventDescription", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "timeRange", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static EventColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new EventColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Event";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Event";
    }

    @SuppressWarnings("cast")
    public static com.example.itinerarymanagementapp.models.Event createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.itinerarymanagementapp.models.Event obj = null;
        if (update) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
            EventColumnInfo columnInfo = (EventColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class);
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
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uuid")) {
                if (json.isNull("uuid")) {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.Event.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.Event.class, json.getString("uuid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uuid'.");
            }
        }

        final com_example_itinerarymanagementapp_models_EventRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) obj;
        if (json.has("category")) {
            if (json.isNull("category")) {
                objProxy.realmSet$category(null);
            } else {
                objProxy.realmSet$category((String) json.getString("category"));
            }
        }
        if (json.has("tripNameReference")) {
            if (json.isNull("tripNameReference")) {
                objProxy.realmSet$tripNameReference(null);
            } else {
                objProxy.realmSet$tripNameReference((String) json.getString("tripNameReference"));
            }
        }
        if (json.has("eventName")) {
            if (json.isNull("eventName")) {
                objProxy.realmSet$eventName(null);
            } else {
                objProxy.realmSet$eventName((String) json.getString("eventName"));
            }
        }
        if (json.has("eventDescription")) {
            if (json.isNull("eventDescription")) {
                objProxy.realmSet$eventDescription(null);
            } else {
                objProxy.realmSet$eventDescription((String) json.getString("eventDescription"));
            }
        }
        if (json.has("timeRange")) {
            if (json.isNull("timeRange")) {
                objProxy.realmSet$timeRange(null);
            } else {
                objProxy.realmSet$timeRange((String) json.getString("timeRange"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.itinerarymanagementapp.models.Event createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.itinerarymanagementapp.models.Event obj = new com.example.itinerarymanagementapp.models.Event();
        final com_example_itinerarymanagementapp_models_EventRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) obj;
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
            } else if (name.equals("category")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$category((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$category(null);
                }
            } else if (name.equals("tripNameReference")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$tripNameReference((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$tripNameReference(null);
                }
            } else if (name.equals("eventName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$eventName(null);
                }
            } else if (name.equals("eventDescription")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$eventDescription((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$eventDescription(null);
                }
            } else if (name.equals("timeRange")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$timeRange((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$timeRange(null);
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

    static com_example_itinerarymanagementapp_models_EventRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class), false, Collections.<String>emptyList());
        io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy obj = new io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.itinerarymanagementapp.models.Event copyOrUpdate(Realm realm, EventColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Event object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.itinerarymanagementapp.models.Event) cachedRealmObject;
        }

        com.example.itinerarymanagementapp.models.Event realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
            long pkColumnKey = columnInfo.uuidColKey;
            String value = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$uuid();
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
                    realmObject = new io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.itinerarymanagementapp.models.Event copy(Realm realm, EventColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Event newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.itinerarymanagementapp.models.Event) cachedRealmObject;
        }

        com_example_itinerarymanagementapp_models_EventRealmProxyInterface unmanagedSource = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.uuidColKey, unmanagedSource.realmGet$uuid());
        builder.addString(columnInfo.categoryColKey, unmanagedSource.realmGet$category());
        builder.addString(columnInfo.tripNameReferenceColKey, unmanagedSource.realmGet$tripNameReference());
        builder.addString(columnInfo.eventNameColKey, unmanagedSource.realmGet$eventName());
        builder.addString(columnInfo.eventDescriptionColKey, unmanagedSource.realmGet$eventDescription());
        builder.addString(columnInfo.timeRangeColKey, unmanagedSource.realmGet$timeRange());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_itinerarymanagementapp_models_EventRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.itinerarymanagementapp.models.Event object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        long tableNativePtr = table.getNativePtr();
        EventColumnInfo columnInfo = (EventColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$category = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
        }
        String realmGet$tripNameReference = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$tripNameReference();
        if (realmGet$tripNameReference != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, realmGet$tripNameReference, false);
        }
        String realmGet$eventName = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventName();
        if (realmGet$eventName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventNameColKey, objKey, realmGet$eventName, false);
        }
        String realmGet$eventDescription = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventDescription();
        if (realmGet$eventDescription != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, realmGet$eventDescription, false);
        }
        String realmGet$timeRange = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$timeRange();
        if (realmGet$timeRange != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeRangeColKey, objKey, realmGet$timeRange, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        long tableNativePtr = table.getNativePtr();
        EventColumnInfo columnInfo = (EventColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.Event object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.Event) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$category = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
            }
            String realmGet$tripNameReference = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$tripNameReference();
            if (realmGet$tripNameReference != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, realmGet$tripNameReference, false);
            }
            String realmGet$eventName = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventName();
            if (realmGet$eventName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventNameColKey, objKey, realmGet$eventName, false);
            }
            String realmGet$eventDescription = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventDescription();
            if (realmGet$eventDescription != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, realmGet$eventDescription, false);
            }
            String realmGet$timeRange = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$timeRange();
            if (realmGet$timeRange != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timeRangeColKey, objKey, realmGet$timeRange, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.itinerarymanagementapp.models.Event object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        long tableNativePtr = table.getNativePtr();
        EventColumnInfo columnInfo = (EventColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$category = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$category();
        if (realmGet$category != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.categoryColKey, objKey, false);
        }
        String realmGet$tripNameReference = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$tripNameReference();
        if (realmGet$tripNameReference != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, realmGet$tripNameReference, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, false);
        }
        String realmGet$eventName = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventName();
        if (realmGet$eventName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventNameColKey, objKey, realmGet$eventName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventNameColKey, objKey, false);
        }
        String realmGet$eventDescription = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventDescription();
        if (realmGet$eventDescription != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, realmGet$eventDescription, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, false);
        }
        String realmGet$timeRange = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$timeRange();
        if (realmGet$timeRange != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.timeRangeColKey, objKey, realmGet$timeRange, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timeRangeColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        long tableNativePtr = table.getNativePtr();
        EventColumnInfo columnInfo = (EventColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.Event.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.Event object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.Event) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$category = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$category();
            if (realmGet$category != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.categoryColKey, objKey, realmGet$category, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.categoryColKey, objKey, false);
            }
            String realmGet$tripNameReference = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$tripNameReference();
            if (realmGet$tripNameReference != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, realmGet$tripNameReference, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tripNameReferenceColKey, objKey, false);
            }
            String realmGet$eventName = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventName();
            if (realmGet$eventName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventNameColKey, objKey, realmGet$eventName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.eventNameColKey, objKey, false);
            }
            String realmGet$eventDescription = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$eventDescription();
            if (realmGet$eventDescription != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, realmGet$eventDescription, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.eventDescriptionColKey, objKey, false);
            }
            String realmGet$timeRange = ((com_example_itinerarymanagementapp_models_EventRealmProxyInterface) object).realmGet$timeRange();
            if (realmGet$timeRange != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.timeRangeColKey, objKey, realmGet$timeRange, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timeRangeColKey, objKey, false);
            }
        }
    }

    public static com.example.itinerarymanagementapp.models.Event createDetachedCopy(com.example.itinerarymanagementapp.models.Event realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.itinerarymanagementapp.models.Event unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.itinerarymanagementapp.models.Event();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.itinerarymanagementapp.models.Event) cachedObject.object;
            }
            unmanagedObject = (com.example.itinerarymanagementapp.models.Event) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_itinerarymanagementapp_models_EventRealmProxyInterface unmanagedCopy = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) unmanagedObject;
        com_example_itinerarymanagementapp_models_EventRealmProxyInterface realmSource = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$uuid(realmSource.realmGet$uuid());
        unmanagedCopy.realmSet$category(realmSource.realmGet$category());
        unmanagedCopy.realmSet$tripNameReference(realmSource.realmGet$tripNameReference());
        unmanagedCopy.realmSet$eventName(realmSource.realmGet$eventName());
        unmanagedCopy.realmSet$eventDescription(realmSource.realmGet$eventDescription());
        unmanagedCopy.realmSet$timeRange(realmSource.realmGet$timeRange());

        return unmanagedObject;
    }

    static com.example.itinerarymanagementapp.models.Event update(Realm realm, EventColumnInfo columnInfo, com.example.itinerarymanagementapp.models.Event realmObject, com.example.itinerarymanagementapp.models.Event newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_itinerarymanagementapp_models_EventRealmProxyInterface realmObjectTarget = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) realmObject;
        com_example_itinerarymanagementapp_models_EventRealmProxyInterface realmObjectSource = (com_example_itinerarymanagementapp_models_EventRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.Event.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.uuidColKey, realmObjectSource.realmGet$uuid());
        builder.addString(columnInfo.categoryColKey, realmObjectSource.realmGet$category());
        builder.addString(columnInfo.tripNameReferenceColKey, realmObjectSource.realmGet$tripNameReference());
        builder.addString(columnInfo.eventNameColKey, realmObjectSource.realmGet$eventName());
        builder.addString(columnInfo.eventDescriptionColKey, realmObjectSource.realmGet$eventDescription());
        builder.addString(columnInfo.timeRangeColKey, realmObjectSource.realmGet$timeRange());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Event = proxy[");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{category:");
        stringBuilder.append(realmGet$category() != null ? realmGet$category() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tripNameReference:");
        stringBuilder.append(realmGet$tripNameReference() != null ? realmGet$tripNameReference() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventName:");
        stringBuilder.append(realmGet$eventName() != null ? realmGet$eventName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{eventDescription:");
        stringBuilder.append(realmGet$eventDescription() != null ? realmGet$eventDescription() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timeRange:");
        stringBuilder.append(realmGet$timeRange() != null ? realmGet$timeRange() : "null");
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
        com_example_itinerarymanagementapp_models_EventRealmProxy aEvent = (com_example_itinerarymanagementapp_models_EventRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aEvent.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aEvent.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aEvent.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
