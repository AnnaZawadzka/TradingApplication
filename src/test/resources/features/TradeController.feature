Feature: Trade controller cases

  Scenario Outline:
    Given one security "<security>" and two users "<user1>" and "<user2>" exist
    When user "<user1>" puts a "buy" order with fulfilled "false" for security "<security>" with a price of "<priceBuy>" and quantity of "<qtyBuy>"
    And user "<user2>" puts a "sell" order with fulfilled "false" for security "<security>" with a price of "<priceSell>" and quantity of "<qtySell>"
    Then a trade occurs with the price of "<tradePrice>" and quantity of "<tradeQty>"

    Examples:
      | security | user1   | user2 | priceBuy | qtyBuy | priceSell | qtySell | tradePrice | tradeQty |
      | WSB      | Diamond | Paper | 101      | 50     | 100       | 100     | 100        | 50       |

  Scenario Outline:
    Given one security "<security>" and two users "<user1>" and "<user2>" exist
    When user "<user1>" puts a "buy" order with fulfilled "<fulfilled>" for security "<security>" with a price of "<priceBuy>" and quantity of "<qtyBuy>"
    And user "<user2>" puts a "sell" order with fulfilled "<fulfilled>" for security "<security>" with a price of "<priceSell>" and quantity of "<qtySell>"
    Then a trade in not found

    Examples:
      | security | user1   | user2 | fulfilled | priceBuy | qtyBuy | priceSell | qtySell |
      | A        | Diamond | Paper | true      | 101      | 50     | 100       | 100     |
      | B        | Diamond | Paper | false     | 100      | 100    | 101       | 50      |