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
public class com_example_itinerarymanagementapp_models_UserRealmProxy extends com.example.itinerarymanagementapp.models.User
    implements RealmObjectProxy, com_example_itinerarymanagementapp_models_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long uuidColKey;
        long firstNameColKey;
        long lastNameColKey;
        long birthdayColKey;
        long usernameColKey;
        long passwordColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.uuidColKey = addColumnDetails("uuid", "uuid", objectSchemaInfo);
            this.firstNameColKey = addColumnDetails("firstName", "firstName", objectSchemaInfo);
            this.lastNameColKey = addColumnDetails("lastName", "lastName", objectSchemaInfo);
            this.birthdayColKey = addColumnDetails("birthday", "birthday", objectSchemaInfo);
            this.usernameColKey = addColumnDetails("username", "username", objectSchemaInfo);
            this.passwordColKey = addColumnDetails("password", "password", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.uuidColKey = src.uuidColKey;
            dst.firstNameColKey = src.firstNameColKey;
            dst.lastNameColKey = src.lastNameColKey;
            dst.birthdayColKey = src.birthdayColKey;
            dst.usernameColKey = src.usernameColKey;
            dst.passwordColKey = src.passwordColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.example.itinerarymanagementapp.models.User> proxyState;

    com_example_itinerarymanagementapp_models_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.itinerarymanagementapp.models.User>(this);
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
    public String realmGet$firstName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.firstNameColKey);
    }

    @Override
    public void realmSet$firstName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.firstNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.firstNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.firstNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.firstNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$lastName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.lastNameColKey);
    }

    @Override
    public void realmSet$lastName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lastNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.lastNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lastNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.lastNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$birthday() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthdayColKey);
    }

    @Override
    public void realmSet$birthday(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthdayColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthdayColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthdayColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthdayColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$username() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usernameColKey);
    }

    @Override
    public void realmSet$username(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usernameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.usernameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usernameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usernameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordColKey);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "User", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "uuid", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "firstName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "lastName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "birthday", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "username", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.example.itinerarymanagementapp.models.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.itinerarymanagementapp.models.User obj = null;
        if (update) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class);
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
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uuid")) {
                if (json.isNull("uuid")) {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy) realm.createObjectInternal(com.example.itinerarymanagementapp.models.User.class, json.getString("uuid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uuid'.");
            }
        }

        final com_example_itinerarymanagementapp_models_UserRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) obj;
        if (json.has("firstName")) {
            if (json.isNull("firstName")) {
                objProxy.realmSet$firstName(null);
            } else {
                objProxy.realmSet$firstName((String) json.getString("firstName"));
            }
        }
        if (json.has("lastName")) {
            if (json.isNull("lastName")) {
                objProxy.realmSet$lastName(null);
            } else {
                objProxy.realmSet$lastName((String) json.getString("lastName"));
            }
        }
        if (json.has("birthday")) {
            if (json.isNull("birthday")) {
                objProxy.realmSet$birthday(null);
            } else {
                objProxy.realmSet$birthday((String) json.getString("birthday"));
            }
        }
        if (json.has("username")) {
            if (json.isNull("username")) {
                objProxy.realmSet$username(null);
            } else {
                objProxy.realmSet$username((String) json.getString("username"));
            }
        }
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.itinerarymanagementapp.models.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.itinerarymanagementapp.models.User obj = new com.example.itinerarymanagementapp.models.User();
        final com_example_itinerarymanagementapp_models_UserRealmProxyInterface objProxy = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) obj;
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
            } else if (name.equals("firstName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$firstName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$firstName(null);
                }
            } else if (name.equals("lastName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$lastName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$lastName(null);
                }
            } else if (name.equals("birthday")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$birthday((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$birthday(null);
                }
            } else if (name.equals("username")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$username((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$username(null);
                }
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
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

    static com_example_itinerarymanagementapp_models_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class), false, Collections.<String>emptyList());
        io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy obj = new io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.itinerarymanagementapp.models.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.example.itinerarymanagementapp.models.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.example.itinerarymanagementapp.models.User) cachedRealmObject;
        }

        com.example.itinerarymanagementapp.models.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
            long pkColumnKey = columnInfo.uuidColKey;
            String value = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$uuid();
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
                    realmObject = new io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.itinerarymanagementapp.models.User copy(Realm realm, UserColumnInfo columnInfo, com.example.itinerarymanagementapp.models.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.itinerarymanagementapp.models.User) cachedRealmObject;
        }

        com_example_itinerarymanagementapp_models_UserRealmProxyInterface unmanagedSource = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.uuidColKey, unmanagedSource.realmGet$uuid());
        builder.addString(columnInfo.firstNameColKey, unmanagedSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameColKey, unmanagedSource.realmGet$lastName());
        builder.addString(columnInfo.birthdayColKey, unmanagedSource.realmGet$birthday());
        builder.addString(columnInfo.usernameColKey, unmanagedSource.realmGet$username());
        builder.addString(columnInfo.passwordColKey, unmanagedSource.realmGet$password());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_itinerarymanagementapp_models_UserRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.itinerarymanagementapp.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$firstName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
        }
        String realmGet$lastName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
        }
        String realmGet$birthday = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$birthday();
        if (realmGet$birthday != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthdayColKey, objKey, realmGet$birthday, false);
        }
        String realmGet$username = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
        }
        String realmGet$password = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.User object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$firstName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
            }
            String realmGet$lastName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
            }
            String realmGet$birthday = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$birthday();
            if (realmGet$birthday != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthdayColKey, objKey, realmGet$birthday, false);
            }
            String realmGet$username = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
            }
            String realmGet$password = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.itinerarymanagementapp.models.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class);
        long pkColumnKey = columnInfo.uuidColKey;
        String primaryKeyValue = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$uuid();
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
        String realmGet$firstName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$firstName();
        if (realmGet$firstName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.firstNameColKey, objKey, false);
        }
        String realmGet$lastName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$lastName();
        if (realmGet$lastName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lastNameColKey, objKey, false);
        }
        String realmGet$birthday = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$birthday();
        if (realmGet$birthday != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthdayColKey, objKey, realmGet$birthday, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthdayColKey, objKey, false);
        }
        String realmGet$username = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$username();
        if (realmGet$username != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usernameColKey, objKey, false);
        }
        String realmGet$password = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.itinerarymanagementapp.models.User.class);
        long pkColumnKey = columnInfo.uuidColKey;
        com.example.itinerarymanagementapp.models.User object = null;
        while (objects.hasNext()) {
            object = (com.example.itinerarymanagementapp.models.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$uuid();
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
            String realmGet$firstName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$firstName();
            if (realmGet$firstName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.firstNameColKey, objKey, realmGet$firstName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.firstNameColKey, objKey, false);
            }
            String realmGet$lastName = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$lastName();
            if (realmGet$lastName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.lastNameColKey, objKey, realmGet$lastName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.lastNameColKey, objKey, false);
            }
            String realmGet$birthday = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$birthday();
            if (realmGet$birthday != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthdayColKey, objKey, realmGet$birthday, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthdayColKey, objKey, false);
            }
            String realmGet$username = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$username();
            if (realmGet$username != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.usernameColKey, objKey, realmGet$username, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.usernameColKey, objKey, false);
            }
            String realmGet$password = ((com_example_itinerarymanagementapp_models_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
            }
        }
    }

    public static com.example.itinerarymanagementapp.models.User createDetachedCopy(com.example.itinerarymanagementapp.models.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.itinerarymanagementapp.models.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.itinerarymanagementapp.models.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.itinerarymanagementapp.models.User) cachedObject.object;
            }
            unmanagedObject = (com.example.itinerarymanagementapp.models.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_itinerarymanagementapp_models_UserRealmProxyInterface unmanagedCopy = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) unmanagedObject;
        com_example_itinerarymanagementapp_models_UserRealmProxyInterface realmSource = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$uuid(realmSource.realmGet$uuid());
        unmanagedCopy.realmSet$firstName(realmSource.realmGet$firstName());
        unmanagedCopy.realmSet$lastName(realmSource.realmGet$lastName());
        unmanagedCopy.realmSet$birthday(realmSource.realmGet$birthday());
        unmanagedCopy.realmSet$username(realmSource.realmGet$username());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());

        return unmanagedObject;
    }

    static com.example.itinerarymanagementapp.models.User update(Realm realm, UserColumnInfo columnInfo, com.example.itinerarymanagementapp.models.User realmObject, com.example.itinerarymanagementapp.models.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_itinerarymanagementapp_models_UserRealmProxyInterface realmObjectTarget = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) realmObject;
        com_example_itinerarymanagementapp_models_UserRealmProxyInterface realmObjectSource = (com_example_itinerarymanagementapp_models_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.itinerarymanagementapp.models.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.uuidColKey, realmObjectSource.realmGet$uuid());
        builder.addString(columnInfo.firstNameColKey, realmObjectSource.realmGet$firstName());
        builder.addString(columnInfo.lastNameColKey, realmObjectSource.realmGet$lastName());
        builder.addString(columnInfo.birthdayColKey, realmObjectSource.realmGet$birthday());
        builder.addString(columnInfo.usernameColKey, realmObjectSource.realmGet$username());
        builder.addString(columnInfo.passwordColKey, realmObjectSource.realmGet$password());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{uuid:");
        stringBuilder.append(realmGet$uuid() != null ? realmGet$uuid() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{firstName:");
        stringBuilder.append(realmGet$firstName() != null ? realmGet$firstName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lastName:");
        stringBuilder.append(realmGet$lastName() != null ? realmGet$lastName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthday:");
        stringBuilder.append(realmGet$birthday() != null ? realmGet$birthday() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{username:");
        stringBuilder.append(realmGet$username() != null ? realmGet$username() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
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
        com_example_itinerarymanagementapp_models_UserRealmProxy aUser = (com_example_itinerarymanagementapp_models_UserRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUser.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUser.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
