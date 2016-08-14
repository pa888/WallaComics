Agenda:

• Create a master-detail Android application that lists your favorite character’s comics:
- The master scene will display all the comics for the character, where each cell will display the comic’s title and thumbnail image.
- The detail screen will display a random image for the selected comic, along with the title and the description of the comic (or any other relevant information you want).

•	  Use the Marvel Public API http://developer.marvel.com/docs in order to fetch your character’s comics.


Take special care when developing your app to these key points:

•	  Project architecture

•	  Design Patterns

•	  Best practices


•	Bonus Points:

•	  MultiThreading

•	  Unit Tests

•	  Instrumentational tests

•	  Animations

•	  Scrolling performance


API info
Authorization: all requests must pass 3 parameters using URL encoding
•	“apikey": the public key

•	“ts": a timestamp (or other long string which can change on a request-by-request
basis)

•	“hash": a md5 digest of the ts parameter, your private key and your public key (e.g.
md5(ts+privateKey+publicKey))

More info here: http://developer.marvel.com/documentation/authorization
