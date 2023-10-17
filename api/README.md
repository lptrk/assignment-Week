# Assignment Week



Your customer is the “HorseFeedingArea Germany GmbH & Co KG”. HorseFeedingArea (HFA) builds a new product that automates horse feeding for the next generation stables. Horses will have a (removable) RFID chip implanted in the ear. Based on this chip, feeding stations can recognize horses and release food as configured. After the horse is fed, it will leave the feeding station. The leftover food will weigh, and the food can be emptied.

That way, HFA wants to revolutionize horse stables, as connectivity to mobile applications or web interfaces is possible.



Your assignment is to create a REST service that manages horses and their feeding schedules.



The application should be created with best practices in mind. Your customer needs access to your GitHub project after the project is finished.



You will need to learn about how to work with date and times in Java:

https://docs.oracle.com/javase/tutorial/datetime/TOC.html



You are free to choose additional technology to your liking, but at a minimum it should contain the following:



- MySQL

- Spring Data JDBC (RowMapper or Entities) or Spring Data JPA (with Hibernate)

- Spring MVC

- Spring Boot



## Application Features



### Create REST services for:



- Creating, Updating, Removing and Reading a stable

- Adding, removing, updating and reading horses and necessary data

- Create services for maintaining feeding preferences for horses

- Create services for checking what horses are eligible for feeding at this time or a manually entered time (see: @RequestParam for additional parameters)

- Create services for releasing food (mark a feeding operation as “done”). In real life, Horses can walk toward feeding stations where the RFID chip causes this operation.

- Create services to check if horses have not been fed even when eligible for more than $x hours.

- Create a service that reports horses who have missed their feeding range 1, 2, or more times in a row.

- Create a service that reports horses that didn't complete their meals.



## Horses:

… have a GUID (necessary for the RFID chip) which needs to be created by the software

… can feed 1..x times a day

… have a name (official name and nickname). The official name is needed for doctors, the nickname is needed for the owner

… have a breed: https://en.wikipedia.org/wiki/List_of_horse_breeds

… have an owner and are assigned to a stable.



## Food:

Horses can eat 1-5 times a day within a feeding range. The ranges cannot overlap.

Horses can eat a different kinds of food in one feeding. Not all kinds of food need to be available in a feeding. In the example, two times only hay, 1-time oat and muesli, 1 time just oat.



All services should have JUnit test coverage.



In this assignment, all further ideas are welcome. You can change these requirements in way that makes more sense to you or in a way you can implement new features or ideas not mentioned here.



P.S.: If you think this assignment is too good to be accurate and you consider doing a business out of it, please check your competition first: https://aktivstall.de/en/hit-automated-feeders-and-feeding-racks/ 

 