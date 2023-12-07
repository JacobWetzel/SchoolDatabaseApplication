# SchoolDatabaseApplication
CMPSC431W - Build your own DB application Project


# BUILD SETUP

Enter/create the directory where you want to keep the repository

*1) Clone into directory*

`git clone https://github.com/JacobWetzel/SchoolDatabaseApplication.git`

*2) If you do not have gradle version 4.4.X, update to at least gradle version 4.4.1*

`sudo apt update `

`sudo apt install gradle`

*3) Build and Run *

`gradle build`

`gradle run`







# MANUAL

Features:

1) Login as either a student or faculty
2) Faculty can add a student to the database
3) Faculty can remove a student from the database
4) Faculty can view all students who currently attend
5) Faculty can order the students by their GPA
6) Faculty can view all classes currently offered
7) Faculty can edit a student's information (Name, GPA, year, etc)
8) TODO - FACULTY CAN ADD CLASSES OFFERED
9) TODO - Students can add classes if they want to take them
10) Students can view their advisor
11) Students can view the classes they've taken


#HOW TO USE

Login via a student login or faculty login 
(Faculty login example -> Username = 1111, password = 11111111)
(Student login example -> Username = 11111, password = 111111111)

# Editing or Removing a Class
1) Login as faculty
2) navigate to the "Modify Class" page by clicking on the "Modify Class" button
3) select the class from the drop down that you want to edit or remove
4) select either the remove button or edit button above the back button
5) If editing, a new page will show up pre filled with the classes existing values
6) edit desired values and click submit

#Editing or Removing a Student
1) Login as faculty
2) navigate to the "Modify Student" page by clicking on the "Modify Student" button
3) enter the students ID number in the provided space
4) to remove select the remove button to edit select edit
5) If editing, a new page will show up pre-filled with the students information
6) adjust desired values and click submit

# View all students
1) Login as facuty
2) click the "View Students" button
3) a new page will appear with all of the students information
4) you are able to sort this by GPA if you would like by clicking the "Sort by GPA" button

Because this uses a GUI interface, each feature is denoted by the button on the screen. For example, if a user wanted to view their advisor, they would just click the 'view advisor' button. Similarly

