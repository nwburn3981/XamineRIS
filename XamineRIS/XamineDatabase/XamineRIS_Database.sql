-- Database for our XamineRIS project 
-- should be able to stroe the information of all the obejcts in paly within the project 

-- Uer Permission -- 
-- This table will hold the permission levels we will be using in our project 
-- a permission needs an access level , the name of the program name , and the 
-- program names codename. Because access levels will determine what GUI is called 
-- only the access level needs to be a primary key 

CREATE TABLE permission (
accesslvl int ,
programName VARCHAR(255),
codeName VARCHAR(255) ,
PRIMARY KEY(accesslvl)) ;

-- User --
-- The user table will store all the users of the XamineRIS system. 
-- each user should have a unique user name that will differentiate it from 
-- other users and thus, this will be used for the primary key. Each user has 
-- an access level so this will be inherited from the permission table 
CREATE TABLE user (
userName VARCHAR(255) ,
firstName VARCHAR(255) ,
lastName VARCHAR(255) ,
password VARCHAR(255) ,
email VARCHAR(255) ,
codeName VARCHAR(255),
isActive boolean ,
isStaff boolean ,
isSuperUser boolean ,
accesslvl int ,
PRIMARY KEY(userName) ,
FOREIGN KEY(accesslvl) REFERENCES permission(accesslvl));

-- patient --
-- the patient table will store all our patients of the XamineRIS system.
-- Each patient needs a unqiue patientID (only visible to the staff) and the 
-- Doctor who referred them for imaging. These two conditions will make the primary 
-- key as each patient needs a dr and id to keep them unique and to keep track of 
-- who referred them. The username of the refferring dr is suffiecient as both 
-- Priamry and Foreign keys.
CREATE TABLE patient (
patientID VARCHAR(255) ,
referringDoctorUserName VARCHAR(255) ,
firstName VARCHAR(255) ,
lastName VARCHAR(255) ,
email VARCHAR(255) ,
dateOfBirth date ,
gender VARCHAR(255) ,
allergyLatex boolean ,
allergyXrayDye boolean ,
allergyMridye boolean ,
notes VARCHAR(2047) ,
phoneNumber VARCHAR(15) ,
PRIMARY KEY(patientID, referringDoctorUserName) ,
FOREIGN KEY(referringDoctorUserName) REFERENCES user(userName)) ;

-- team -- 
-- the team table will store all the teams working in the XamineRIS system / hospital
-- Each team can have up to 10 members (references by their unqiue userName) and are kept seperate 
-- via the unique teamID 
CREATE TABLE team (
teamID VARCHAR(255) ,
teamName VARCHAR(255) ,
teamMember01 VARCHAR(255) ,
teamMember02 VARCHAR(255) ,
teamMember03 VARCHAR(255) ,
teamMember04 VARCHAR(255) ,
teamMember05 VARCHAR(255) ,
teamMember06 VARCHAR(255) ,
teamMember07 VARCHAR(255) ,
teamMember08 VARCHAR(255) ,
teamMember09 VARCHAR(255) ,
teamMember10 VARCHAR(255) ,
PRIMARY KEY(teamID) ,
FOREIGN KEY(teamMember01) REFERENCES user(userName) ,
FOREIGN KEY(teamMember02) REFERENCES user(userName) ,
FOREIGN KEY(teamMember03) REFERENCES user(userName) ,
FOREIGN KEY(teamMember04) REFERENCES user(userName) ,
FOREIGN KEY(teamMember05) REFERENCES user(userName) ,
FOREIGN KEY(teamMember06) REFERENCES user(userName) ,
FOREIGN KEY(teamMember07) REFERENCES user(userName) ,
FOREIGN KEY(teamMember08) REFERENCES user(userName) ,
FOREIGN KEY(teamMember09) REFERENCES user(userName) ,
FOREIGN KEY(teamMember10) REFERENCES user(userName));

-- modality table -- 
-- the modality table will store all the equipment in use and is referenced in the order section
-- each modliaty is kept seperate vida a unique modalityID and it's usage tracked via inUse boolean.
-- additonally the room number associated with the equipement is also stored inside the modality table 
CREATE TABLE modality (
modalityID VARCHAR(255) ,
modalityName VARCHAR(255) ,
inUse boolean ,
roomID VARCHAR(255) ,
PRIMARY KEY(modalityID));

-- Order -- 
-- The imagingOrder is the piece of information that passes through each users hands. It is responsible for housing 
-- patient infomration , appointment information, visit reasoning, Referring dr notes, Radiologist analysis, and equipemnt/ teams 
-- that were used in the order. The images taken to the order are attached to the order via a reference to the orderID which keeps each 
-- order unique. additionally each order requires a patient so it is included in the primary key 
CREATE TABLE imagingOrder (
orderID VARCHAR(255) ,
patientID VARCHAR(255) ,
orderStatus VARCHAR(255) ,
appointment datetime ,
visitReason VARCHAR(255) ,
imagingNeeded VARCHAR(255) ,
teamID VARCHAR(255) ,
technicalReport VARCHAR(2500) ,
modalityID VARCHAR(255) ,
imageFolderID VARCHAR(255) ,
PRIMARY KEY(orderID, patientID),
FOREIGN KEY(patientID) REFERENCES patient(patientID),
FOREIGN KEY(teamID) REFERENCES team(teamID),
FOREIGN KEY(modalityID) REFERENCES modality(modalityID));

-- image -- 
-- The image table is responsible for storing all the images taken by the XamineRIS system , 
-- each image is tracked via a unique imageID and linked to thier appropriate order via the orderID 
-- the image is stored via the BLOB data type that expands / shrinks depending on the size of the input.
CREATE TABLE image (
imageID VARCHAR(255) ,
orderID VARCHAR(255) ,
imagelabel VARCHAR(255) ,
imageDate datetime ,
imageFile BLOB,
PRIMARY KEY(imageID, orderID),
FOREIGN KEY(orderID) REFERENCES imagingOrder(orderID)) ;











