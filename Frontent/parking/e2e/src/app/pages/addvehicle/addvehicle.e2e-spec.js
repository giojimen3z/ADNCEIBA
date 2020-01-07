  
describe('agregar vehiculo', function() {

    it('Debería crear un vehiculo', function() {
        browser.get('menu/Add');
        let campoIdentificador = element(by.id('plate'));
        let placavehiculo = 'ADC ' + Math.random().toString(36).substring(2, 7)+'E';
        

        

        campoIdentificador.sendKeys(placavehiculo);
        expect(campoIdentificador.getAttribute('value')).toBe(placavehiculo);
        element(by.id('typeid')).sendKeys('Moto');
        expect(element(by.id('typeid')).getAttribute('value')).toBe('1');
        element(by.id('cc')).sendKeys('200')
        expect(element(by.id('cc')).getAttribute('value')).toBe('200');
        
        let button = element(by.id('saveVehicle'));

        button.click();
        

        var timeoutInMilliseconds = 1000;
        browser.wait(protractor.ExpectedConditions.alertIsPresent(), timeoutInMilliseconds);
        var alertDialog = browser.switchTo().alert();
        expect(alertDialog.getText()).toEqual("El vehiculo se agrego crorrectamente");

    })

});