package tests

import base.AbstractChromeWebDriverTest
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import pages.*
import parameters.CarDataParameter
import scenario.ConsentScenario

@RunWith(Parameterized::class)
class InsuranceCarTest: AbstractChromeWebDriverTest() {

    @Parameterized.Parameter
    lateinit var carDataParameter: CarDataParameter

    @Test
    fun `add insurance fo car`() {
        val mainInsurancePage = MainInsurancePage(driver)
        mainInsurancePage.openPage()

        // Accept cookies
        val consentScenario = ConsentScenario(driver)
        consentScenario.acceptAllCookies()

        // Click continue on main page
        mainInsurancePage.clickOnTheContinueButton()

        // Click continue on registred owner page
        val selectRegisteredOwnerPage = SelectRegisteredOwnerPage(driver)
        selectRegisteredOwnerPage.clickOnTheContinueButton()

        val selectCarPage = SelectCarPage(driver)
        // Open find by brand tab
        selectCarPage.clickOnTheFindByBrandButton()

        // Select a car brand from parameters
        selectCarPage.clickOnCarBrand(carDataParameter.carBrand)

        // Select car model from parameters
        val selectModelCarPage = SelectModelCarPage(driver)
        selectModelCarPage.clickOnCarModel(carDataParameter.carModel)

        // Select body type if specified
        val bodyType = carDataParameter.bodyType
        if (bodyType != null) {
            val selectBodyCarTypePage = SelectBodyCarTypePage(driver)
            selectBodyCarTypePage.clickOnBodyType(bodyType)
        }

        // Select fuel type
        val selectFuelTypePage = SelectFuelTypePage(driver)
        selectFuelTypePage.clickOnFuelType(carDataParameter.fuelType)

        // Select engine power
        val selectEnginePowerPage = SelectEnginePowerPage(driver)
        selectEnginePowerPage.clickOnEnginePower(carDataParameter.enginePower)

        // Select expected car
        val selectEngineTwoPage = CarSelectionPage(driver)
        selectEngineTwoPage.clickOnCorrectCar(carDataParameter.expectedCar)
    }

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun carParameters(): List<CarDataParameter> {
            return arrayListOf(
                // AUDI
                CarDataParameter(
                    carBrand = "AUDI",
                    carModel = "A4",
                    bodyType = "Cabrio",
                    fuelType = "Benzin",
                    enginePower = "96 kW / 131 PS",
                    expectedCar = "A4 CABRIOLET 2.0"
                ),
                CarDataParameter(
                    carBrand = "AUDI",
                    carModel = "A1",
                    bodyType = null,
                    fuelType = "Benzin",
                    enginePower = "60 kW / 82 PS",
                    expectedCar = "A1 1.0 TFSI"
                ),
                CarDataParameter(
                    carBrand = "AUDI",
                    carModel = "Q5",
                    bodyType = null,
                    fuelType = "Hybrid",
                    enginePower = "155 kW / 211 PS",
                    expectedCar = "Q5 2.0 TFSI HYBRID QUATTRO"
                ),
                // VW
                CarDataParameter(
                    carBrand = "VW",
                    carModel = "Caddy",
                    bodyType = "Kombi",
                    fuelType = "Benzin",
                    enginePower = "44 kW / 60 PS",
                    expectedCar = "CADDY"
                ),
                CarDataParameter(
                    carBrand = "VW",
                    carModel = "Golf",
                    bodyType = "Cabrio",
                    fuelType = "Benzin",
                    enginePower = "53 kW / 72 PS",
                    expectedCar = "GOLF-CABRIOLET"
                ),
                CarDataParameter(
                    carBrand = "VW",
                    carModel = "Polo",
                    bodyType = "Coupe",
                    fuelType = "Benzin",
                    enginePower = "33 kW / 45 PS",
                    expectedCar = "POLO COUPE"
                ),
                // BMW
                CarDataParameter(
                    carBrand = "BMW",
                    carModel = "1er",
                    bodyType = "Cabrio",
                    fuelType = "Benzin",
                    enginePower = "105 kW / 143 PS",
                    expectedCar = "118I CABRIO"
                ),
                CarDataParameter(
                    carBrand = "BMW",
                    carModel = "2er",
                    bodyType = "Cabrio",
                    fuelType = "Benzin",
                    enginePower = "100 kW / 136 PS",
                    expectedCar = "218I CABRIO"
                ),
                CarDataParameter(
                    carBrand = "BMW",
                    carModel = "X1",
                    bodyType = null,
                    fuelType = "Benzin",
                    enginePower = "100 kW / 136 PS",
                    expectedCar = "X1 SDRIVE 18I"
                )
            )
        }
    }
}