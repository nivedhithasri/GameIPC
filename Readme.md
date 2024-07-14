--------------------
Task Question:
--------------------
Given a Player class - an instance of which can communicate with other Players.
1. Create 2 Player instances
2. One of the players should send a message to second player (let's call this player "initiator")
3. When a player receives a message, it should reply with a message that contains the received message concatenated with the value of a counter holding the number of messages this player already sent.
4. Finalize the program (gracefully) after the initiator sent 10 messages and received back 10 messages (stop condition)
5. Both players should run in the same java process (strong requirement)
6. Document for every class the responsibilities it has.
7. opposite to 5: have every player in a separate JAVA process.

--------------------
Classes Definitions:
--------------------
MainClassApp Class:
1. Starting point of the application(main class).
2. It is used to initialize Player1(Client) and Player2(Server) instances to run them in same process.
3. Writes the received message of Player1 and Player2 class in messages folder 

Player1 Class(Server):
1. Player1 Class creates host for the messaging.
2. After creating the host, it starts to listen inputStream.
3. Once Player2 is connected and received the first message, application continues messaging.
4. Append the counting value of the received message from Player2 and send back the Player2.
5. It stores the chat conversations in Player1Messages.txt file

Player2 Class(Client):
1. Player2 Class establishes the connection, If any Server is available.
2. Once it is connected to a Server, it sends the first message. 
3. After, it starts listening and receives the inputs from the Player1 class.
4. It stores the chat conversations in Player2Messages.txt file
 
Constant Class:
1. Constant class is used to maintain initialization of repetitive variables.

-----------------------------
Steps to run the application:
-----------------------------
1. To run the application same JAVA PROCESS

-> Open terminal and run the below cmd in the terminal
        mvn exec:java@MainClassApp

-> To Check the result please check the messages folder in project directory. It has process Id(PID) details and received messages.
   Player1Messages.txt, Player2Messages.txt files

2. To run the application different JAVA PROCESS

-> Open two terminals and run the below cmd in the first terminal
        mvn exec:java@Server

-> Run the below cmd in second terminal
        mvn exec:java@Client

-> To Check the result please check the messages folder in project directory. It has process Id(PID) details and received messages.
   Player1Messages.txt, Player2Messages.txt files


