import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;

/**
 * @author Zhao Liu
 *
 */

public class NNCalcController1Test {

    @Test
    public void testProcessClearEvent_1() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("1234");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processClearEvent();

        NaturalNumber newBottom = model.bottom();
        NaturalNumber expectedBottom = new NaturalNumber2("0");

        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessClearEvent_2() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("1234567899876541230");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processClearEvent();

        NaturalNumber newBottom = model.bottom();
        NaturalNumber expectedBottom = new NaturalNumber2("0");

        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessSwapEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("456");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("123");

        NaturalNumber expectedTop = new NaturalNumber2("123");
        NaturalNumber expectedBottom = new NaturalNumber2("456");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processSwapEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessEnterEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("456");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("123");

        NaturalNumber expectedTop = new NaturalNumber2("123");
        NaturalNumber expectedBottom = new NaturalNumber2("123");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processEnterEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessAddEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("456");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("123");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("579");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processAddEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessSubtractEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("456");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("123");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("333");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processSubtractEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessMultiplyEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("1000");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("5");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("5000");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processMultiplyEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessDivideEvent_1() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("1000");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("5");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("200");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processDivideEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessDivideEvent_2() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("9");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("5");

        NaturalNumber expectedTop = new NaturalNumber2("4");
        NaturalNumber expectedBottom = new NaturalNumber2("1");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processDivideEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessPowerEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("2");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("3");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("8");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processPowerEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessRootEvent() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("27");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("3");

        NaturalNumber expectedTop = new NaturalNumber2("0");
        NaturalNumber expectedBottom = new NaturalNumber2("3");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processRootEvent();

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessAddNewDigitEvent_1() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("27");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("3");

        NaturalNumber expectedTop = new NaturalNumber2("27");
        NaturalNumber expectedBottom = new NaturalNumber2("30");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processAddNewDigitEvent(0);

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

    @Test
    public void testProcessAddNewDigitEvent_2() {
        NNCalcView view = new NNCalcView1();
        NNCalcModel model = new NNCalcModel1();

        NaturalNumber top = model.top();
        top.setFromString("27");

        NaturalNumber bottom = model.bottom();
        bottom.setFromString("95");

        NaturalNumber expectedTop = new NaturalNumber2("27");
        NaturalNumber expectedBottom = new NaturalNumber2("953");

        NNCalcController controller = new NNCalcController1(model, view);
        controller.processAddNewDigitEvent(3);

        NaturalNumber newTop = model.top();
        NaturalNumber newBottom = model.bottom();

        assertEquals(expectedTop, newTop);
        assertEquals(expectedBottom, newBottom);
    }

}
