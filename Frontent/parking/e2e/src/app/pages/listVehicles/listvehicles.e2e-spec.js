
describe('Listar vehiculos', function() {

    it('Debería listar los vehiculos', function() {
        browser.get('menu/vehicles');

        let listaVehiculos = element.all(by.css('.card'));
        expect(listaVehiculos.count()).toBeGreaterThanOrEqual(0);
    })

});