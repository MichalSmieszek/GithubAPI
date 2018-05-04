Hello! :)

This app should write name of last modified repo.

I used https://api.github.com/users/allegro/repos?per_page=100000. I chose number of 100,000, because I don't truly believe, 
Allegro can have more repos, so I have every repo in one place and this tasks is much easier than loop by pages.

Maybe I should say several words about tests. I decided to do 3 kind of tests. Firstly was test on response code = 200. Nextly I tested
pattern to SimpleDataFormat. I did eight tests checking if methods after and before with my pattern work correctly.
Last test, I created, was to check if number of public_repos from https://api.github.com/users/allegro is equal to jsonarray length  from 
https://api.github.com/users/allegro/repos?per_page=100000. It was caused the number from https://api.github.com/users/allegro/repos wasn't
good.

Some challenges in the project :) : <br />
- First time I was working with SimpleDataFormat<br />
- I haven't so much experience with unit test

Thank you (from mountain) in advance for your time.
