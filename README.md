# JavaDalom
Week10B - Music manager application

Application for searching MP3

This application is able to search in a given file list which contains only mp3 files. The user can define custom search criteria which may contain any of the ID3 tag properties and/or the name of the file.

Parameters:
- system waits for a list of mp3 files which should be a prepared file list
- system asks the search keyword
- system asks which property should be used in the search process
- if there is no keyword and any criteria the full list is the result
- by default all ID3 property and the filename is in the search process
- if any concrete property or properties choosed the search should go only these fields
- system logs out the result file list to the console
- system logs out the count of results in this form:
count: {count_of_result_list}


Week 11B - Service with sockets

Let users to use any of the services in one place published by our team and other Codecool teams too. Services developed by other teams is available on the network. Our task was to publish our service and let it be used remotely based on socket communication.
Our other task was to integrate the client modules of other teams into an application, where the user can use any of the services published on the net.

MP3Search: the user can search in his MP3 files a pattern by a given ID3TagProperty or a file name.

Parameters:

Input of server: List<File>, ID3TagProperty <= means the list of the user's MP3 files and ID3TagProperty means where the user can search.If this parameter is null, that means the user can search everywhere (file name and all properties)
Output of server: List<File> <= result of the search

Properties:

- application require a List of File object where search, a String what the user can search and an ID3PropertyTag where the user can search in.
- application has to return with the list of the files where pattern is found in the given properties
- if property is null application should search everywhere: file name and every id3 tag property
- there can be only 1 instance of Socket on each client and server sides and endpoints should use these to communicate with each other
- connection has to be kept alive. Server has to run infinitely and has to process as much requests as client sent. Socket on client side can only be terminated when program terminates.