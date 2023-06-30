Feature: Air

  Scenario: Создание элемента Air с помощью createNatureElements
    Given list of elements 'Air'
    When creating new element Air
    Then checking new element Air

  Scenario: Объединение воздуха с пустым массивом элементов
    Given пустой список элементов
    And элемент Air
    When я вызываю метод connectElements
    Then метод возвращает пустой массив

  Scenario: Объединение воздуха с землей
    Given список элементов [Earth, Air]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Dust

  Scenario: Объединение воздуха с огнем
    Given список элементов [Air, Fire]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Energy

  Scenario: Объединение воздуха с водой
    Given список элементов [Air, Water]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Rain

  Scenario: Объединение воздуха с воздухом
    Given список элементов [Air, Air]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Pressure