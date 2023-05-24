package com.tunein.radiotime.data.parser

const val jsonWithoutChildrenElements = """
    {
  "head": {
    "title": "Variety",
    "status": "200"
  },
  "body": [
    {
      "element": "outline",
      "type": "link",
      "text": "Overnights",
      "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p116844&filter=p:topic",
      "guide_id": "p116844",
      "subtext": "Overnights is heard from 2am to 6am nationally...",
      "genre_id": "g29",
      "item": "show",
      "image": "http://cdn-profiles.tunein.com/p116844/images/logoq.png?t=3",
      "current_track": "Overnights is heard from 2am to 6am nationally...",
      "preset_id": "p116844"
    },
    {
      "element": "outline",
      "type": "link",
      "text": "Live Wire with Luke Burbank",
      "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p118803&filter=p:topic",
      "guide_id": "p118803",
      "subtext": "Like late-night for radio, Live Wire is hosted...",
      "genre_id": "g88",
      "item": "show",
      "image": "http://cdn-profiles.tunein.com/p118803/images/logoq.png?t=1",
      "current_track": "Like late-night for radio, Live Wire is hosted...",
      "preset_id": "p118803"
    },
    {
      "element": "outline",
      "type": "link",
      "text": "Tent Show Radio",
      "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p393&filter=p:topic",
      "guide_id": "p393",
      "subtext": "First broadcast in 1994, Tent Show Radio is a...",
      "genre_id": "g79",
      "item": "show",
      "image": "http://cdn-profiles.tunein.com/p393/images/logoq.png?t=2",
      "current_track": "First broadcast in 1994, Tent Show Radio is a...",
      "preset_id": "p393"
    },
    {
      "element": "outline",
      "type": "link",
      "text": "Disclosure",
      "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p11742&filter=p:topic",
      "guide_id": "p11742",
      "subtext": "Conspiracy, your privacy, prophecy and the...",
      "genre_id": "g271",
      "item": "show",
      "image": "http://cdn-profiles.tunein.com/p11742/images/logoq.png?t=1",
      "current_track": "Conspiracy, your privacy, prophecy and the...",
      "preset_id": "p11742"
    },
    {
      "element": "outline",
      "type": "link",
      "text": "JES | Unleash The Beat",
      "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p487442&filter=p:topic",
      "guide_id": "p487442",
      "subtext": "JES Radio Mixshow, Album, Taxigirl Mashups,...",
      "genre_id": "g79",
      "item": "show",
      "image": "http://cdn-profiles.tunein.com/p487442/images/logoq.png?t=2",
      "current_track": "JES Radio Mixshow, Album, Taxigirl Mashups,...",
      "preset_id": "p487442"
    }
  ]
}
    """

const val jsonWithChildrenElements = """
    {
  "head": {
    "title": "Soul & R&B",
    "status": "200"
  },
  "body": [
    {
      "element": "outline",
      "text": "Shows",
      "key": "shows",
      "children": [
        {
          "element": "outline",
          "type": "link",
          "text": "Juke In The Back",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p310492&filter=p:topic",
          "guide_id": "p310492",
          "subtext": "At the end of the Second World War, economics...",
          "genre_id": "g16",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p310492/images/logoq.png?t=3",
          "current_track": "At the end of the Second World War, economics...",
          "preset_id": "p310492"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Fish Fry",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p1942&filter=p:topic",
          "guide_id": "p1942",
          "subtext": "A public radio party in your living room, as...",
          "genre_id": "g106",
          "item": "show",
          "image": "http://cdn-radiotime-logos.tunein.com/p1942q.png",
          "current_track": "A public radio party in your living room, as...",
          "preset_id": "p1942"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "American Routes",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p35388&filter=p:topic",
          "guide_id": "p35388",
          "subtext": "Each week, Nick Spitzer covers vast musical...",
          "genre_id": "g62",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p35388/images/logoq.jpg",
          "current_track": "Each week, Nick Spitzer covers vast musical...",
          "preset_id": "p35388"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Deep House Cat",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p144441&filter=p:topic",
          "guide_id": "p144441",
          "subtext": "Founded and established by dj philE in 2007...",
          "genre_id": "g2757",
          "item": "show",
          "image": "http://cdn-radiotime-logos.tunein.com/p144441q.png",
          "current_track": "Founded and established by dj philE in 2007...",
          "preset_id": "p144441"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Soul Cafe",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p1006594&filter=p:topic",
          "guide_id": "p1006594",
          "subtext": "The Softest Place On The Planet Built For Your...",
          "genre_id": "g71",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p1006594/images/logoq.png?t=1",
          "current_track": "The Softest Place On The Planet Built For Your...",
          "preset_id": "p1006594"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "He Who Mixes",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p1008289&filter=p:topic",
          "guide_id": "p1008289",
          "subtext": "DJ mixes for the culture. Genres: Hip Hop |...",
          "genre_id": "g128",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p1008289/images/logoq.png?t=156839",
          "current_track": "DJ mixes for the culture. Genres: Hip Hop |...",
          "preset_id": "p1008289"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Soul Explosion Podcast",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p990302&filter=p:topic",
          "guide_id": "p990302",
          "subtext": "What is the definition of \"soul\" ?",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p990302/images/logoq.png?t=636319",
          "current_track": "What is the definition of \"soul\" ?",
          "preset_id": "p990302"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Soul Discovery",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p171697&filter=p:topic",
          "guide_id": "p171697",
          "subtext": "The show’s passion and dedication to its...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p171697/images/logoq.jpg?t=1",
          "current_track": "The show’s passion and dedication to its...",
          "preset_id": "p171697"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Full Throttle Radio Worldwide",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p405662&filter=p:topic",
          "guide_id": "p405662",
          "subtext": "3 Hours of high octane Hip Hop, RnB, Reggae...",
          "genre_id": "g128",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p405662/images/logoq.jpg?t=151671",
          "current_track": "3 Hours of high octane Hip Hop, RnB, Reggae...",
          "preset_id": "p405662"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "The Love Zone with Maurice THE VOICE Watts on WHCR 90.3FM - NY",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p580765&filter=p:topic",
          "guide_id": "p580765",
          "subtext": "With over 39 years on radio, Maurice caters to...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-radiotime-logos.tunein.com/p580765q.png",
          "current_track": "With over 39 years on radio, Maurice caters to...",
          "preset_id": "p580765"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "DJ Frosty",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p1101612&filter=p:topic",
          "guide_id": "p1101612",
          "subtext": "DJ Frosty Radio",
          "genre_id": "g128",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p1101612/images/logoq.jpg",
          "current_track": "DJ Frosty Radio",
          "preset_id": "p1101612"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "CLUB 102 LIVE (Channel #3)",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p721038&filter=p:topic",
          "guide_id": "p721038",
          "subtext": "Tune in for Club 102 Live bringing you some of...",
          "genre_id": "g54",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p721038/images/logoq.png?t=1",
          "current_track": "Tune in for Club 102 Live bringing you some of...",
          "preset_id": "p721038"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "A Bowl of Soul",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p381804&filter=p:topic",
          "guide_id": "p381804",
          "subtext": "A Bowl of Soul is a Mixed Stew of Soul Music...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p381804/images/logoq.png?t=1",
          "current_track": "A Bowl of Soul is a Mixed Stew of Soul Music...",
          "preset_id": "p381804"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Rockhouse on Oldies 104",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p891194&filter=p:topic",
          "guide_id": "p891194",
          "subtext": "Join Topeka's own Marshall Barber as he takes...",
          "genre_id": "g16",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p891194/images/logoq.png?t=156805",
          "current_track": "Join Topeka's own Marshall Barber as he takes...",
          "preset_id": "p891194"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Best Smooth Grooves UK : Host Rod Lucas",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p375047&filter=p:topic",
          "guide_id": "p375047",
          "subtext": "Soft Soul Smooth Jazz from London UK with Host...",
          "genre_id": "g71",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p375047/images/logoq.png?t=1",
          "current_track": "Soft Soul Smooth Jazz from London UK with Host...",
          "preset_id": "p375047"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "The Basic Soul Show",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p475580&filter=p:topic",
          "guide_id": "p475580",
          "subtext": "The UK's Simon Harrison puts down all the...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p475580/images/logoq.png?t=1",
          "current_track": "The UK's Simon Harrison puts down all the...",
          "preset_id": "p475580"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "6thManRadio",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p513681&filter=p:topic",
          "guide_id": "p513681",
          "subtext": "THE HOME OF ADULT CONTEMPORARY HIP HOP AND R&B...",
          "genre_id": "g3",
          "item": "show",
          "image": "http://cdn-radiotime-logos.tunein.com/p513681q.png",
          "current_track": "THE HOME OF ADULT CONTEMPORARY HIP HOP AND R&B...",
          "preset_id": "p513681"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Testify! with Larry Grogan | WFMU",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p991573&filter=p:topic",
          "guide_id": "p991573",
          "subtext": "A roadmap that reveals the highways, byways,...",
          "genre_id": "g61",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p991573/images/logoq.jpg",
          "current_track": "A roadmap that reveals the highways, byways,...",
          "preset_id": "p991573"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "DNCREDIBLE DJ FREDDIE FRED's Podcast",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p887879&filter=p:topic",
          "guide_id": "p887879",
          "subtext": "R&B,OLD SCHOOL,SOULFUL HOUSE,CLASSIC HIPHOP...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p887879/images/logoq.png?t=15",
          "current_track": "R&B,OLD SCHOOL,SOULFUL HOUSE,CLASSIC HIPHOP...",
          "preset_id": "p887879"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Streetz Radio",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p679906&filter=p:topic",
          "guide_id": "p679906",
          "subtext": "Streetz Radio was founded in 2003 by owner...",
          "genre_id": "g128",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p679906/images/logoq.png?t=52",
          "current_track": "Streetz Radio was founded in 2003 by owner...",
          "preset_id": "p679906"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Ship Full of Bombs",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p891772&filter=p:topic",
          "guide_id": "p891772",
          "subtext": "Bringing you the very best music across the...",
          "genre_id": "g2748",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p891772/images/logoq.png?t=1",
          "current_track": "Bringing you the very best music across the...",
          "preset_id": "p891772"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Inspiration FM",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p550182&filter=p:topic",
          "guide_id": "p550182",
          "subtext": "Inspiration FM is a community led and managed...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p550182/images/logoq.png?t=1",
          "current_track": "Inspiration FM is a community led and managed...",
          "preset_id": "p550182"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "N'ite Moods \"Old School Quiet Storm\"",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p796342&filter=p:topic",
          "guide_id": "p796342",
          "subtext": "Mia the “Love Goddess of The Airwaves”...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p796342/images/logoq.png?t=153191",
          "current_track": "Mia the “Love Goddess of The Airwaves”...",
          "preset_id": "p796342"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Beale Street Caravan",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p1027346&filter=p:topic",
          "guide_id": "p1027346",
          "subtext": "For more than 20 years, BSC has been capturing...",
          "genre_id": "g106",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p1027346/images/logoq.png?t=636404",
          "current_track": "For more than 20 years, BSC has been capturing...",
          "preset_id": "p1027346"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "Sam Sylk Show",
          "URL": "http://opml.radiotime.com/Tune.ashx?c=pbrowse&id=p44434&filter=p:topic",
          "guide_id": "p44434",
          "subtext": "Sam Sylk Radio and Digital Personality...",
          "genre_id": "g18",
          "item": "show",
          "image": "http://cdn-profiles.tunein.com/p44434/images/logoq.png?t=1",
          "current_track": "Sam Sylk Radio and Digital Personality...",
          "preset_id": "p44434"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "More Shows",
          "URL": "http://opml.radiotime.com/Browse.ashx?offset=26&id=c1367173&filter=p:topic",
          "key": "nextShows"
        }
      ]
    },
    {
      "element": "outline",
      "text": "Explore Soul & R&B",
      "key": "related",
      "children": [
        {
          "element": "outline",
          "type": "link",
          "text": "Funk",
          "URL": "http://opml.radiotime.com/Browse.ashx?id=g2774&filter=p:topic",
          "guide_id": "g2774"
        },
        {
          "element": "outline",
          "type": "link",
          "text": "R&B Music",
          "URL": "http://opml.radiotime.com/Browse.ashx?id=g4152&filter=p:topic",
          "guide_id": "g4152"
        }
      ]
    }
  ]
}
 """