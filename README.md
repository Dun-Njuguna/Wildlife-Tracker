# Wildlife Tracker
### CREATED BY Duncan Kariuki

----------------------------------------------------------------------

## Project Objectives
To create an application that allows rangers to add citings of animals and describe the animals health.

----------------------------------------------------------------------

## Technologies used
This project has been written using java,spark framework,Postgres SQL - Database, css, jquery and html.


-----------------------------------------------------------------------------

## Behaviour driven Development (BDD)
|#User inputs   |  #Example outputs |         
|---------------|-------------------|

|User adds an endangered animal       |Endangered animal is added |
|User adds an unendangered animal        | Unendangered animal is added  |
|User reports an animal sighting      | Animal sighting is reported  |

---------------------------------------------------------------------------------

## Setup/Installation Requirements
To use the application
  1. Clone the repository.
  2. Navigate to the folder.
  3. To re-create the database, use the following steps;
  4. Open folder with terminal.
  5. Run PSQL:(if you don't have postgress install it first).
  6. CREATE DATABASE wildlife_tracker;
  7. CREATE TABLE animals (id serial PRIMARY KEY, name varchar, rangername varchar, type varchar, age varchar, location varchar, health varchar, citingtime varchar);
  8. Open with the text editor(sublime prefered) of your choice(optional step)
  9. Run "gradle build" to install dependencies.
  10. Run "gradle run" then open your browser.

---------------------------------------------------------------------

## Known bugs
As of witting, there are no Known bugs.

## Support or contribution instructions
If you require to make any changes to this project, then reach out to me on the email below.

## Contact information
For any questions or suggestions please feel free to reach out to me at duncankariuki60@gmail.com

-----------------------------------------------------------------------------

## Copyright and license information

MIT License

Copyright (c) [2019] [Duncan Kariuki]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.