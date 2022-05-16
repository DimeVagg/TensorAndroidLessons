package com.dimevagg.recyclerviewproject

data class Musician(
    var id: Int,
    val fullName: String,
    val photoUrl: String,
    val bandName: String,
    var liked: Boolean
) {
    companion object {
        fun getMockMusicians() = mutableListOf(
            Musician(
                0, "Mårten Hagström",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/M%C3%A5rten_Hagstr%C3%B6m%2C_Meshuggah.jpg/320px-M%C3%A5rten_Hagstr%C3%B6m%2C_Meshuggah.jpg",
                "Meshuggah",
                false
            ),
            Musician(
                1,
                "Fredrik Thordendal",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f4/Fredrik_Thordendal_2005.jpg/391px-Fredrik_Thordendal_2005.jpg",
                "Meshuggah",
                false
            ),
            Musician(
                2,
                "Tomas Haake",
                "https://upload.wikimedia.org/wikipedia/commons/9/98/Tomas_Haake_2005.jpg",
                "Meshuggah",
                false
            ),
            Musician(
                3,
                "Dick Lövgren",
                "https://upload.wikimedia.org/wikipedia/commons/0/09/Meshuggah_-_Dick_L%C3%B6vgren_-_2008_Melbourne.jpg",
                "Meshuggah",
                false
            ),
            Musician(
                4,
                "Jens Kidman",
                "https://upload.wikimedia.org/wikipedia/commons/4/4b/Jens_Kidman_Meshuggah_Live_at_Getaway_Rock_Festival_2012.jpg",
                "Meshuggah",
                false
            ),
            Musician(
                5,
                "Brian May",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/78/Brian_May_2017_Guitar_Cropped.jpg/220px-Brian_May_2017_Guitar_Cropped.jpg",
                "Queen",
                false
            ),
            Musician(
                6,
                "Roger Taylor",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Queen_And_Adam_Lambert_-_The_O2_-_Tuesday_12th_December_2017_QueenO2121217-47_%2839066610085%29_Cropped.jpg/220px-Queen_And_Adam_Lambert_-_The_O2_-_Tuesday_12th_December_2017_QueenO2121217-47_%2839066610085%29_Cropped.jpg",
                "Queen",
                false
            ),
            Musician(
                7,
                "John Deacon",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Bass_player_queen.jpg/220px-Bass_player_queen.jpg",
                "Queen",
                false
            ),
            Musician(
                8,
                "Freddie Mercury",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ef/Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg/220px-Freddie_Mercury_performing_in_New_Haven%2C_CT%2C_November_1977.jpg",
                "Queen",
                false
            ),
            Musician(
                9,
                "Marty Friedman",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/99/Marty_Friedman_in_Tokyo--2009-03.jpg/220px-Marty_Friedman_in_Tokyo--2009-03.jpg",
                "Cacophony",
                false
            ),
            Musician(
                10,
                "Jason Becker",
                "data:image/jpeg;base64,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",
                "Cacophony",
                false
            ),
            Musician(
                11,
                "Andy Summers",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b1/Andy_Summers_with_guitar_2015.jpg/220px-Andy_Summers_with_guitar_2015.jpg",
                "The Police",
                false
            ),
            Musician(
                12,
                "Stewart Copeland",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Stewart_Copeland_Marseille_2008.png/289px-Stewart_Copeland_Marseille_2008.png",
                "The Police",
                false
            ),
            Musician(
                13,
                "Gordon Matthew Sumner",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/40/Sting_in_April_2018.jpg/220px-Sting_in_April_2018.jpg",
                "The Police",
                false
            ),
            Musician(
                14,
                "Dave Gahan",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/DaveGahanbyNOA-HASSIN.JPG/220px-DaveGahanbyNOA-HASSIN.JPG",
                "Depeche Mode",
                false
            ),
            Musician(
                15,
                "Martin Gore",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d8/Martin_Gore_in_2009.jpg/220px-Martin_Gore_in_2009.jpg",
                "Depeche Mode",
                false
            ),
            Musician(
                16,
                "Andy Fletcher",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Andrew_Fletcher_%28Depeche_Mode%29_%C3%A0_Bordeaux_en_janvier_2018..jpg/220px-Andrew_Fletcher_%28Depeche_Mode%29_%C3%A0_Bordeaux_en_janvier_2018..jpg",
                "Depeche Mode",
                false
            ),
            Musician(
                17,
                "Alan Wilder",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Alan_Wilder.JPG/197px-Alan_Wilder.JPG",
                "Depeche Mode",
                false
            )
        )
    }
}
