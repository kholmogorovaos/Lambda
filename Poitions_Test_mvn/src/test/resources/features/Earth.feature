Feature: Earth
  Scenario: Создание элемента Earth с помощью createNatureElements
    Given list of elements 'Earth'
    When creating new element Earth
    Then checking new element Earth

  Scenario: Объединение воздуха с пустым массивом элементов
    Given пустой список элементов
    And элемент Earth
    When я вызываю метод connectElements
    Then метод возвращает пустой массив

  Scenario: Объединение земли с воздухом
    Given список элементов [Earth, Air]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Dust

  Scenario: Объединение земли с землей
    Given список элементов [Earth, Earth]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Pressure

  Scenario: Объединение земли с огнем
    Given список элементов [Earth, Fire]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Lava

  Scenario: Объединение воздуха с водой
    Given список элементов [Earth, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Mud