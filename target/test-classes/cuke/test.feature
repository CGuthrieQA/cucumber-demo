Feature: Google search for kittens
  I want to search for kittens on google!

  Scenario: Google kitten images
    Given that I can access google
    When I search for kittens
    Then I should be able to view kittens