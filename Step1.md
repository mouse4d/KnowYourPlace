# Step 1 #

* API only
* add player
    * name
* add match
    * kicker
    * pingpong
* get player ratings
    * specific one
    * all
* get history
    * specific player
    * all players
    
    
# Brainstorm API's

`baseUrl = https://gamerater.com/`

---
`POST /{company}/kicker`
Add a match of kicker. An example adding a micro-tournament 2/3

Initially I thought about adding the scores for all matches in a micro-tournament, ex:

A:
```
#!JSON
{
  "teamA" : {
      "players" : ["pId1", "pId2"],
      "scores" : [6, 1, 6]
   },
   
   "teamB": {
      "players" : ["pId3", "pId4"],
      "scores" : [4, 6, 3]
   },
}
```

B:
```
#!JSON
{
  "teams" : [
        ["pId1", "pId2"],
        ["pId3", "pId4"]
  ],
  "scores": [
        [6,4],
        [1,6],
        [6,3]
  ]
}
```

but now I think it's too much, so I think to stick to smth like this:
C:
```
#!JSON
{
  "teams" : [
        ["pId1", "pId2"],
        ["pId3", "pId4"]
  ],
  "score": [2,1]
}
```
and maybe add `type=match|tournament` in the JSON data, or rather in the path, like `/{company}/kicker/match`



Response:

A:
```
#!JSON

{
    "pId1" : {
        "newRating" : 1440,
        "diff" : 23 
    },
    "pId2" : {
        "newRating" : 2114,
        "diff" : 4 
    },
    "pId3" : {
        "newRating" : 2001,
        "diff" : -32 
    },
    "pId1" : {
        "newRating" : 1210,
        "diff" : -2 
    },
}
```
B:
```
#!JSON

{
    "players" : [
        {
            "id" : "pId1",
            "newRating" : 1440,
            "diff" : 23    
        },
        {
            "id" : "pId2",
            "newRating" : 2114,
            "diff" : 4    
        },
        {
            "id" : "pId3",
            "newRating" : 2001,
            "diff" : -32    
        },
        {
            "id" : "pId4",
            "newRating" : 1210,
            "diff" : -2    
        }
    ]
}
```

---
`POST /{company}/pingpong`

A:
```
#!JSON
{
  "playerA" : {
      "id" : "pId1",
      "scores" : [11, 2, 12]
   },
   
   "playerB": {
      "id" : "pId2",
      "scores" : [0, 11, 10]
   }
}
```
B:
```
#!JSON
{
  "players" : [
    "pId1", "pId2"
  ],
   
   "scores": [
        [11, 0],
        [2, 11], 
        [12, 10]
   ]
}
```

Response - same as with Kicker
---

`POST /{company}/player/{pId}`

```
#!JSON

{
  "name" : "Vasilii"
}

```

`GET /{company}/player/{pId}`

A:
```
#!JSON

{
    "name" : "Vasilii",
    "games" : {
        "kicker" : {
            "score" : 1400
        },
        "pingpong" : {
            "score" : 2100
        }
    }
}
```

B:
```
#!JSON

{
    "name" : "Vasilii",
    "games" : [
        {
            "name" : "kicker",
            "score" : 1400
        },
        {
            "name" : "pingpong",
            "score" : 2100
        }
    ]
}
```
