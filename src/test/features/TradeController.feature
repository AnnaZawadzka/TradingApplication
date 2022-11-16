Feature: Trade controller cases

  Scenario Outline:
    Given one security <security> and two users <user1> and <user2> exist
    When user <user1> puts a buy order for security <security> with a price of <price1> and quantity of <qty1>
    And user <user2> puts a sell order for security <security> with a price of <price2> and a quantity of <qty2>
    Then a trade occurs with the price of <trade_price> and quantity of <trade_qty>

    Examples:
      | security | user1   | user2 | price1 | price2 | qty1 | qty2 | trade_price | trade_qty |
      | WSB      | Diamond | Paper | 101    | 100    | 50   | 100  | 100         | 50        |