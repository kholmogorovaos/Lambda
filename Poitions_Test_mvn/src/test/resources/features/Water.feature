Feature: Water
  Scenario: Создание элемента Water с помощью createNatureElements
    Given list of elements 'Water'
    When creating new element Water
    Then checking new element Water

  Scenario: Объединение воды с пустым массивом элементов
    Given пустой список элементов
    And элемент Water
    When я вызываю метод connectElements
    Then метод возвращает пустой массив

  Scenario: Объединение воды с воздухом
    Given список элементов [Air, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Rain

  Scenario: Объединение воды с землей
    Given список элементов [Earth, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Mud

  Scenario: Объединение воды с водой
    Given список элементов [Water, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Sea

  Scenario: Объединение воды с огнем
    Given список элементов [Fire, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Steam

  Scenario: Объединение воды с энергией
    Given список элементов [Water, Energy]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Steam