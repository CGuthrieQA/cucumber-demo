Feature: Google search for various animals
  I want to search google for different animals!
  
  Scenario: Search for "<Animal>" images
    Given that I can access "<Domain>"
    When I search for "<Animal>"
    Then I should be able to view "<Animal>"
    
    Examples:
    	| Animal | Domain |
    	| kittens | www.google.com |
    	| puppies | www.google.com |
    	| rabbits | www.bing.com |
    	| hamsters | www.google.com |