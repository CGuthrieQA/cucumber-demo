Feature: Google various search terms
  I want to search for different terms

  Scenario Outline: Google "<Animal>" images
    Given that I can access "<Domain>"
    When I search for "<Animal>"
    Then I should be able to view "<Animal>"

    Examples: 
      | Animal | Domain |
      | kittens | www.google.com |
      | puppies | www.google.com |
      | newts | www.google.com |
      | parrots | www.bing.com |
      | rabbits | www.google.com |
      | hamsters | www.google.com |