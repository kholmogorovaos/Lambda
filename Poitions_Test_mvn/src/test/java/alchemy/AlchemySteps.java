package alchemy;

import elements.basic.*;
import elements.derived.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static alchemy.Alchemy.connectElements;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlchemySteps {
    private NatureElement element;
    private List<String> elements;
    private NatureElement[] elementis;
    private NatureElement[] connectedElements;

    @Given("list of elements {string}")
    public void listOfElements(String string) {
        elements = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(string, ",");
        while (tokenizer.hasMoreTokens()) {
            elements.add(tokenizer.nextToken().trim());
        }
    }
    @When("creating new element Air")
    public void creatingNewElementAir() {
        element = NatureElement.create("Air");
    }
    @Then("checking new element Air")
    public void checkingNewElementAir() {
        assertTrue(element instanceof Air);
    }

    @When("creating new element Earth")
    public void creatingNewElementEarth() {
        element = NatureElement.create("Earth");
    }

    @Then("checking new element Earth")
    public void checkingNewElementEarth() {
        assertTrue(element instanceof Earth);
    }

    @When("creating new element Fire")
    public void creatingNewElementFire() {
        element = NatureElement.create("Fire");
    }

    @Then("checking new element Fire")
    public void checkingNewElementFire() {
        assertTrue(element instanceof Fire);
    }

    @When("creating new element Water")
    public void creatingNewElementWater() {
        element = NatureElement.create("Water");
    }

    @Then("checking new element Water")
    public void checkingNewElementWater() {
        assertTrue(element instanceof Water);
    }

    @When("creating new element Energy")
    public void creatingNewElementEnergy() {
        element = NatureElement.create("Energy");
    }

    @Then("checking new element Energy")
    public void checkingNewElementEnergy() {
        assertTrue(element instanceof Energy);
    }

    @Given("пустой список элементов")
    public void emptyElementsList() {
        elementis = new NatureElement[0];
    }

    @Given("элемент Air")
    public void airElement() {
        elementis = new NatureElement[]{new Air()};
    }

    @Given("элемент Earth")
    public void earthElement() {
        elementis = new NatureElement[]{new Earth()};
    }

    @Given("элемент Fire")
    public void fireElement() {
        elementis = new NatureElement[]{new Fire()};
    }

    @Given("элемент Water")
    public void waterElement() {
        elementis = new NatureElement[]{new Water()};
    }

    @Given("элемент Dust")
    public void dustElement() {
        elementis = new NatureElement[]{new Dust()};
    }
    @Given("список элементов [Earth, Air]")
    public void listElementsEA() {
        elementis = new NatureElement[]{new Earth(), new Air()};
    }
    @Given("список элементов [Air, Fire]")
    public void listElementsAF() {
        elementis = new NatureElement[]{new Air(), new Fire()};
    }
    @Given("список элементов [Air, Water]")
    public void listElementsAW() {
        elementis = new NatureElement[]{new Air(), new Water()};
    }
    @Given("список элементов [Air, Air]")
    public void listElementsAA() {
        elementis = new NatureElement[]{new Air(), new Air()};
    }
    @Given("список элементов [Earth, Earth]")
    public void listElementsEE() {
        elementis = new NatureElement[]{new Earth(), new Earth()};
    }
    @Given("список элементов [Earth, Fire]")
    public void listElementsEF() {
        elementis = new NatureElement[]{new Earth(), new Fire()};
    }
    @Given("список элементов [Earth, Water]")
    public void listElementsEW() {
        elementis = new NatureElement[]{new Earth(), new Water()};
    }
    @Given("список элементов [Fire, Fire]")
    public void listElementsFF() {
        elementis = new NatureElement[]{new Fire(), new Fire()};
    }
    @Given("список элементов [Fire, Water]")
    public void listElementsFW() {
        elementis = new NatureElement[]{new Fire(), new Water()};
    }
    @Given("список элементов [Water, Water]")
    public void listElementsWW() {
        elementis = new NatureElement[]{new Water(), new Water()};
    }
    @Given("список элементов [Water, Energy]")
    public void listElementsWE() {
        elementis = new NatureElement[]{new Water(), new Energy()};
    }

    @When("я вызываю метод connectElements")
    public void callConnectElementsMethod() {
        connectedElements = connectElements(elementis);
    }

    @Then("метод возвращает пустой массив")
    public void emptyResultArray() {
        Assert.assertEquals(0, connectedElements.length);
    }

    @Then("в массиве connectedElements появляется новый элемент Dust")
    public void checkDustElementInConnectedElements() {
        boolean containsDust = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Dust) {
                containsDust = true;
                break;
            }
        }
        Assert.assertTrue(containsDust);
    }
    @Then("в массиве connectedElements появляется новый элемент Energy")
    public void checkEnergyElementInConnectedElements() {
        boolean containsEnergy = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Energy) {
                containsEnergy = true;
                break;
            }
        }
        Assert.assertTrue(containsEnergy);
    }
    @Then("в массиве connectedElements появляется новый элемент Rain")
    public void checkRainElementInConnectedElements() {
        boolean containsRain = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Rain) {
                containsRain = true;
                break;
            }
        }
        Assert.assertTrue(containsRain);
    }
    @Then("в массиве connectedElements появляется новый элемент Pressure")
    public void checkPressureElementInConnectedElements() {
        boolean containsPressure = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Pressure) {
                containsPressure = true;
                break;
            }
        }
        Assert.assertTrue(containsPressure);
    }
    @Then("в массиве connectedElements появляется новый элемент Lava")
    public void checkLavaElementInConnectedElements() {
        boolean containsLava = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Lava) {
                containsLava = true;
                break;
            }
        }
        Assert.assertTrue(containsLava);
    }
    @Then("в массиве connectedElements появляется новый элемент Mud")
    public void checkMudElementInConnectedElements() {
        boolean containsMud = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Mud) {
                containsMud = true;
                break;
            }
        }
        Assert.assertTrue(containsMud);
    }
    @Then("в массиве connectedElements появляется новый элемент Steam")
    public void checkSteamElementInConnectedElements() {
        boolean containsSteam = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Steam) {
                containsSteam = true;
                break;
            }
        }
        Assert.assertTrue(containsSteam);
    }
    @Then("в массиве connectedElements появляется новый элемент Sea")
    public void checkSeaElementInConnectedElements() {
        boolean containsSea = false;
        for (NatureElement element : connectedElements) {
            if (element instanceof Sea) {
                containsSea = true;
                break;
            }
        }
        Assert.assertTrue(containsSea);
    }
    @Then("в массиве connectedElements не производит новый элемент")
    public void checkNoNewElementInConnectedElements() {
        try {
            elementis[0].connect(elementis[1]);
            throw new AssertionError("Ожидалось сообщение 'Не производит новый элемент'");
        } catch (UnsupportedOperationException e) {
            if (!e.getMessage().equals("Не производит новый элемент")) {
                throw new AssertionError("Ожидалось сообщение 'Не производит новый элемент', получено: " + e.getMessage());
            }
        }
    }
    @Then("метод возвращает ошибку {string}")
    public void checkNoRightElementInConnectedElements(String errorMessage) {
        try {
            NatureElement element = new Dust();
            NatureElement element1 = new Energy();
            element1.connect(element);
            throw new AssertionError("Ожидалось сообщение '" + errorMessage + "'");
        } catch (UnsupportedOperationException e) {
            if (!e.getMessage().equals(errorMessage)) {
                throw new AssertionError("Ожидалось сообщение '" + errorMessage + "', получено: " + e.getMessage());
            }
        }
    }
}








