Feature: Fire
  Scenario: Создание элемента Fire с помощью createNatureElements
    Given list of elements 'Fire'
    When creating new element Fire
    Then checking new element Fire

  Scenario: Объединение воздуха с пустым массивом элементов
    Given пустой список элементов
    And элемент Fire
    When я вызываю метод connectElements
    Then метод возвращает пустой массив

  Scenario: Объединение огня с воздухом
    Given список элементов [Air, Fire]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Energy

  Scenario: Объединение огня с землей
    Given список элементов [Earth, Fire]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Lava

  Scenario: Объединение огня с огнем
    Given список элементов [Fire, Fire]
    When я вызываю метод connectElements
    Then в массиве connectedElements не производит новый элемент

  Scenario: Объединение огня с водой
    Given список элементов [Fire, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Steam