package dcv.android.machnv.finaltest.data.servicecore;

import android.os.Parcel;
import android.os.Parcelable;

public class PropertyEvent<T> implements Parcelable {
    public static final int STATUS_AVAILABLE = 0;
    public static final int STATUS_UNAVAILABLE = 1;
    public static final Creator<PropertyEvent> CREATOR = new Creator<PropertyEvent>() {
        @Override
        public PropertyEvent createFromParcel(Parcel in) {
            return new PropertyEvent(in);
        }

        @Override
        public PropertyEvent[] newArray(int size) {
            return new PropertyEvent[size];
        }
    };
    private final int mPropertyId;
    private final int mStatus;
    private T mValue;

    public PropertyEvent(int propertyId, int status, T value) {
        mPropertyId = propertyId;
        mStatus = status;
        mValue = value;
    }

    protected PropertyEvent(Parcel in) {
        mPropertyId = in.readInt();
        mStatus = in.readInt();
        String dataClassName = in.readString();
        Class<?> dataClass;
        try {
            dataClass = Class.forName(dataClassName);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class not found: " + dataClassName);
        }
        mValue = (T) in.readValue(dataClass.getClassLoader());
    }

    public T getValue() {
        return mValue;
    }

    public void setValue(T value) {
        mValue = value;
    }

    public int getPropertyId() {
        return mPropertyId;
    }

    public int getStatus() {
        return mStatus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mPropertyId);
        dest.writeInt(mStatus);
        Class<?> dataClass = mValue == null ? null : mValue.getClass();
        dest.writeString(dataClass == null ? null : dataClass.getName());
        dest.writeValue(mValue);
    }
}
