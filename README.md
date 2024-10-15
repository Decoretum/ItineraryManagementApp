
# Bluetility Itinerary

Bluetility Itinerary is a mobile application developed by Gael Estrera, Colleen Barrameda, and Erick Lopez in order to manage user itinerary for various trips and events, and this application also features user authentication in order for data to be kept exclusive for various users. This application is the group's final project output for CSCI 181.05, Special Topics in Software Engineering: Android Development. This application was developed using Java with the aid of Android Studio. <br>

<h2>Function</h2>
The application enables users to manage their itinerary by providing interfaces that create, record, update, and delete trips and events.<br>
Users are also authenticated against the system in order to preserve data integrity between users. Each user is capable of creating their own trips and managing information related to those. <br><br>

Each trip represents a journay that user will undertake or is currently undertaking. A trip would consist of several events. Data pertaining to the events would be exclusive to the referenced trip. Data pertaining to the trip would be exclusive to the user who created the trip. <br><br>

<h3>Camera Support</h3>
The application features mobile camera support which enables photo taking, editing of taken photo, and the assignment of the final photo to an event or a trip. 

<h3>Filtering through Categories</h3>
Events and Trips would be categorized based on the categories that the user will create. This enables dynamic filtering of trips and events depending on the genres and/or purposes of the trips and events.

<h3>User authentication</h3>
User authentication enabled the application to store trip and event data exclusive to the user who created those data. Hence, if User A created a Trip named "Trip New York" and User B created another Trip with the same name, then these data will exist independently from one another. Modifications such as additions or deletion of data regarding these trips will <b>not affect</b> the data of their counterpart. <br><br>

This same logic also applies to Events. Categories created by User A for Trips and Events will also be independent of the categories formed by User B for User B's trips and events, even if the category names will be identical. 

<h2>Entities/Models</h2>
This application features 5 main database entities.<br>

```
User Model

@PrimaryKey
private String uuid;

private String firstName;

private String lastName;

private String birthday;

private String username;

private String password;

```

```
Trip Model

@PrimaryKey
private String uuid;

private String userUUID;

private String category;

private String tripName;

private String description;

```

```
Event Model

@PrimaryKey
private String uuid;

private String category;

private String tripUUID;

private String eventName;

private String eventDescription;

private String timeRange;

private String userUUID;
```

```
Event Category Model

@PrimaryKey
private String uuid;

private String name;
```

```
Trip Category Model

@PrimaryKey
private String uuid;

private String name;


```
