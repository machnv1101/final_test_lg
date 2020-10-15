// ICoreService.aidl
package dcv.test.servicecore;

import dcv.test.servicecore.IPropertyService;
import dcv.test.servicecore.IConfigurationService;

interface ICoreService {
    IPropertyService getPropertyService();
    IConfigurationService getConfigurationService();
}
