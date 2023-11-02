Feature: Managing widgets

  Scenario Outline: User is able to create a new widget via POST request
    When create widget from file <fileName>
    Then widget is created

    Examples:
      | fileName                          |
      | investigated_trend_widget.json    |
      | launchesDurationChart_widget.json |
      | notPassed_widget.json             |
      | overallStatistics_widget.json     |
      | uniqueBugTable_widget.json        |

  Scenario Outline: User is able to update a widget via PUT request
    When create widget from file launchesDurationChart_widget.json
    And update widget with field <field> and value <value>
    Then widget is updated

    Examples:
      | field       | value           |
      | item        | 1               |
      | item        | 600             |
      | item        | 123             |
      | description | new description |
      | description |                 |
      | description | 1               |


