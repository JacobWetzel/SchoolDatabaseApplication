JWetz
JWetz#7318

JWetz — 12/04/2023 10:26 PM
Ima walk home now but if you do I can create a bdf
Old Man — 12/04/2023 10:26 PM
let me just find
it
for some reason it disapears
1) For the most part we followed what we said we would in the team contract. In terms of flow at times progress was at a halt due to Jacob resolving family emergency which caused a little bit of a delay on my work. We stayed very up to date with each other in terms of the project and would also inform one another when we were doing something for the project and when it would be done. I think that we did a good job staying on track and resolving conflicts as well.
2)Looking back on the overall project I enjoyed the development process. I found Stages 1 and 2 to be very useful when working on the final artifact as well as when there were progress issues related to the emergency Jacob experienced. The flow made it feel like a real-world project and the deadlines helped maintain a hard timeline where the team was responsible for the soft timeline. To summarize, I enjoyed the development process. I just wish I understood how much work the initial set-up for the database and UI would take to get it done in a more reasonable manor.
Old Man — 12/05/2023 1:06 PM
Can you send me the word document so I can resubmit
JWetz — 12/05/2023 5:06 PM
Ya! Headed home from work now
Also
I don’t know if you saw but we got scheduled for Thursday at 3
I know you’re busy with other projects, but I’m going to try and make more headwind on it. But not anything over the top, just what we missed in terms of needed functionality
So that’s a modify fn and roll back fn
We also have a couple tables we didn’t use (and won’t use), ima clean those up as well as comment out unused code
I’m going to try on the gui stuff, but no promises it’ll work or be good lol
Old Man — 12/05/2023 5:17 PM
as long as we get some points I'm good with it. Just please let me know when you resubmit so I can do that same
JWetz — Today at 1:01 PM
ayo still working on changes
but
Ima be ready to present
and send you the final docs to submit
are you going to be at the presentation
Old Man — Today at 1:29 PM
Yea, I'm not sure what building his OH are I'm
JWetz — Today at 1:29 PM
Westgate
are you free now?
if so im in W136 (where we were before)
I got a few more features added yesterday (such as the view class info for the 5 table joins) and I am going to finish up the modification query  as well as the sort functionality
Old Man — Today at 1:32 PM
Dude I've been glancing over the sort functionality when I have time, I have no idea why it either isn't redrawing the screen or reassignimg the array
JWetz — Today at 1:33 PM
just do it as a scroll box
thats what i did
much easier
look at the most recent push
Old Man — Today at 1:34 PM
You're telling me, a scrollbox will update but not a label
Wtf
I need to look at this hold on
JWetz — Today at 1:35 PM
I think I used two seperate functions
Old Man — Today at 1:36 PM
What do you mean? For the retrieval?
JWetz — Today at 1:37 PM
nah for update
i think i first setup blanks
then upon view, i call a fucntion that updates all the variable
s
Old Man — Today at 1:40 PM
Gotcha, I pulled, what all is different?
JWetz — Today at 1:41 PM
check student and faculty, viewing all the classes
students can also add classes to a cart
I would start from a fresh pull
do you think you could come to westgate or do you gotta do stuff at home
only askin that way it would be easier to talk
also if you're going to work on the sorting, I am going to get editing a student impl
You missed a call from 
Old Man
 that lasted a minute.
 — Today at 1:44 PM
Old Man — Today at 1:45 PM
yeah I can make my way to west gate
JWetz — Today at 1:45 PM
lets gooooooo
Old Man — Today at 3:11 PM
BUILD SETUP

Enter/create the directory where you want to keep the repository

1) Clone into directory
Expand
message.txt
3 KB
﻿
Old Man
thecaptainpoo
IDK what server to join DM me
BUILD SETUP

Enter/create the directory where you want to keep the repository

1) Clone into directory

git clone https://github.com/JacobWetzel/SchoolDatabaseApplication.git

2) If you do not have gradle version 4.4.X, update to at least gradle version 4.4.1

sudo apt update 

sudo apt install gradle

*3) Build and Run *

gradle build

gradle run
MANUAL

Features:

    Login as either a student or faculty
    Faculty can add a student to the database
    Faculty can remove a student from the database
    Faculty can view all students who currently attend
    Faculty can order the students by their GPA
    Faculty can view all classes currently offered
    Faculty can edit a student's information (Name, GPA, year, etc)
    TODO - FACULTY CAN ADD CLASSES OFFERED
    TODO - Students can add classes if they want to take them
    Students can view their advisor
    Students can view the classes they've taken

#HOW TO USE

Login via a student login or faculty login (Faculty login example -> Username = 1111, password = 11111111) (Student login example -> Username = 11111, password = 111111111)

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
message.txt
3 KB
