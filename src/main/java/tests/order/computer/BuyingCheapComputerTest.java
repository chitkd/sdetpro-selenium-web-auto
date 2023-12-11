package tests.order.computer;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test_data.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.computer.OrderComputerFlow;
import tests.BaseTest;

public class BuyingCheapComputerTest extends BaseTest {
    @Test(dataProvider = "computerData")
    public void testCheapComputerBuying(ComputerData computerData){
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        OrderComputerFlow<CheapComputerComponent> orderComputerFlow = new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData);
        orderComputerFlow.buildCompSpec();
        orderComputerFlow.addItemToCard();
    }

    @DataProvider()
    public ComputerData[] computerData(){
        String relativeDataFileLocation = "/src/main/java/test_data/data.json";
        return DataObjectBuilder.buildDataObjectFrom(relativeDataFileLocation, ComputerData[].class);
    }

}
