Feature: Energy
  Scenario: Создание элемента Energy с помощью createNatureElements
    Given list of elements 'Energy'
    When creating new element Energy
    Then checking new element Energy

  Scenario: Элемент Energy может соединяться с элементом воды
    Given список элементов [Water, Energy]
    When я вызываю метод connectElements
    Then в массиве connectedElements появляется новый элемент Steam

  Scenario: Элемент Energy не может соединяться с другими элементами, кроме Water
    Given элемент Dust
    When я вызываю метод connectElements
    Then метод возвращает ошибку "Недействительное сочетание элементов"