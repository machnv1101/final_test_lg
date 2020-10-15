// IPropertyEventListener.aidl
package dcv.test.servicecore;

import dcv.test.servicecore.PropertyEvent;

interface IPropertyEventListener {
    void onEvent(in PropertyEvent event);
    void onError(in int errorCode);
}
