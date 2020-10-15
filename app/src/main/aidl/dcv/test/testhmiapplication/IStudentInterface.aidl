// IStudentInterface.aidl
package dcv.test.testhmiapplication;

import dcv.test.testhmiapplication.IHMIListener;
import dcv.test.testhmiapplication.TestCapability;

interface IStudentInterface {
    void registerListener(in IHMIListener listener);
    void unregisterListener(in IHMIListener listener);
    TestCapability getCapability();
    void setDistanceUnit(int unit);
    void setConsumptionUnit(int unit);
    void resetData();
}
