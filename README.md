# Spring Boot Project in Docker using Mongo

## Reference Documentation

Deploying Spring Boot and MongoDB as Containers Using Docker and Docker Compose

### Steps docker commands
* **pull mongo image from docker hub docker pull mongo:latest**


* **docker run mongo image docker run -d -p 27017:27017 --name greenmoodmongodb mongo:latest**


* dockerize spring boot application: **docker build -t springboot-mongodb:1.0 .**


* run spring boot docker image and link that container to mongo container docker run -p 7777:7777 --name springboot-mongodb --link greenmoodmongodb:mongo -d springboot-mongodb:1.0

* check docker running containers docker ps it should display two container ids

* check logs of spring boot image docker logs springboot-mongodb

* if all good access your api 

<pre>curl --location --request POST <span class="pl-s"><span class="pl-pds">'</span>http://localhost:8181/books<span class="pl-pds">'</span></span> \
--header <span class="pl-s"><span class="pl-pds">'</span>Content-Type: application/json<span class="pl-pds">'</span></span> \
--data-raw <span class="pl-s"><span class="pl-pds">'</span>{</span>
<span class="pl-s">    "id":1,</span>
<span class="pl-s">    "bookName":"JavaFx",</span>
<span class="pl-s">    "authorName":"Anton"</span>
<span class="pl-s">}<span class="pl-pds">'</span></span></pre>

<ul class="contains-task-list">
<li class="task-list-item"><input type="checkbox" id="" disabled="" class="task-list-item-checkbox" checked=""> login to mongo terminal to verify records <strong><code>docker exec -it greenmoodmongodb bash</code></strong></li>
<li>type mongo and enter</li>
<li>show dbs</li>
<li>use book</li>
<li>show collections</li>
<li>db.book.find().pretty()</li>
</ul>

<p dir="auto"><strong>Use Docker Compose</strong></p>

<ul class="contains-task-list">
<li class="task-list-item"><input type="checkbox" id="" disabled="" class="task-list-item-checkbox" checked=""> Kill running container:</li>
</ul>

<pre><code>docker rm &lt;containerId&gt;
</code></pre>

<h4 dir="auto"><a id="user-content-docker-composeyml" class="anchor" aria-hidden="true" href="#docker-composeyml"><svg class="octicon octicon-link" viewBox="0 0 16 16" version="1.1" width="16" height="16" aria-hidden="true"><path fill-rule="evenodd" d="M7.775 3.275a.75.75 0 001.06 1.06l1.25-1.25a2 2 0 112.83 2.83l-2.5 2.5a2 2 0 01-2.83 0 .75.75 0 00-1.06 1.06 3.5 3.5 0 004.95 0l2.5-2.5a3.5 3.5 0 00-4.95-4.95l-1.25 1.25zm-4.69 9.64a2 2 0 010-2.83l2.5-2.5a2 2 0 012.83 0 .75.75 0 001.06-1.06 3.5 3.5 0 00-4.95 0l-2.5 2.5a3.5 3.5 0 004.95 4.95l1.25-1.25a.75.75 0 00-1.06-1.06l-1.25 1.25a2 2 0 01-2.83 0z"></path></svg></a>docker-compose.yml</h4>

<pre><span class="pl-ent">version</span>: <span class="pl-s"><span class="pl-pds">"</span>3<span class="pl-pds">"</span></span>
<span class="pl-ent">services</span>:
  <span class="pl-ent">greenmoodmongodb</span>:
    <span class="pl-ent">image</span>: <span class="pl-s">mongo:latest</span>
    <span class="pl-ent">container_name</span>: <span class="pl-s"><span class="pl-pds">"</span>greenmoodmongodb<span class="pl-pds">"</span></span>
    <span class="pl-ent">ports</span>:
      - <span class="pl-c1">27017:27017</span>
  <span class="pl-ent">springboot-mongodb</span>:
    <span class="pl-ent">image</span>: <span class="pl-s">springboot-mongodb:1.0</span>
    <span class="pl-ent">container_name</span>: <span class="pl-s">springboot-mongodb</span>
    <span class="pl-ent">ports</span>:
      - <span class="pl-c1">7777:7777</span>
    <span class="pl-ent">links</span>:
      - <span class="pl-s">greenmoodmongodb</span></pre>

<ul class="contains-task-list">
<li class="task-list-item"><input type="checkbox" id="" disabled="" class="task-list-item-checkbox" checked=""> navigate to resources folder:</li>
</ul>

<pre><code>springboot-mongo-docker/src/main/resources and run docker-compose up
</code></pre>


