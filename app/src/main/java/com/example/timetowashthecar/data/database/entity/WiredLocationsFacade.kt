package com.example.timetowashthecar.data.database.entity

class WiredLocationsFacade {
    companion object {
        private val wiredLocationsList: ArrayList<MapCache> = ArrayList()

        fun addDefaultWiredLocationsToList():ArrayList<MapCache> {
            wiredLocationsList.clear()
            wiredLocationsList.add(
                MapCache(
                    0,
                    55.82759684703693,
                    49.094563445955266,
                    "Мойдодыр",
                    3.8,
                    "Kazan",
                    "Russia",
                    "Хусаина Ямашева, 28A"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    1,
                    55.835406208829,
                    49.121933128222544,
                    "Квартал",
                    4.1,
                    "Kazan",
                    "Russia",
                    "ул. Мусина, 61 Д"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    2,
                    55.82753314534038,
                    49.107627952919906,
                    "Мойдодыр",
                    4.4,
                    "Kazan",
                    "Russia",
                    "пр-т. Хусаина Ямашева, 33Б"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    3,
                    55.83158208705062,
                    49.08469955899535,
                    "Клаксон",
                    4.1,
                    "Kazan",
                    "Russia",
                    "ул. Волгоградская, 8к1"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    4,
                    55.8212761176824,
                    49.06751606848644,
                    "Карасики",
                    4.1,
                    "Kazan",
                    "Russia",
                    "ул. Галимджана Баруди, 8"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    5,
                    55.8294311177,
                    49.07322313596985,
                    "Вега",
                    3.6,
                    "Kazan",
                    "Russia",
                    "ул. Восход, 4,"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    6,
                    55.81980501733798,
                    49.046853083626196,
                    "Прачка для тачки",
                    4.1,
                    "Kazan",
                    "Russia",
                    "ул. Лазарева, 13"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    7,
                    55.81208771820881,
                    49.072839047690756,
                    "SMART detailing & carwash",
                    4.5,
                    "Kazan",
                    "Russia",
                    "Краснококшайская ул., 43А"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    8,
                    55.81975028059698,
                    49.106202738427335,
                    "Детейлинг Центр-автомойка Аквалайф",
                    4.1,
                    "Kazan",
                    "Russia",
                    "ул. Чистопольская, 9А"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    9,
                    55.82641232633296,
                    49.08168012558217,
                    "Автосауна № 1",
                    4.3,
                    "Kazan",
                    "Russia",
                    "Тверская ул., 7"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    10,
                    55.8374128590376,
                    49.16006311401413,
                    "Спец-сервис",
                    4.3,
                    "Kazan",
                    "Russia",
                    "ул. Гаврилова, 28А"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    11,
                    55.8410551235372,
                    49.16051761564952,
                    "Автомойка 24",
                    4.3,
                    "Kazan",
                    "Russia",
                    "ул. Гаврилова, 44А"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    12,
                    55.839565659094205,
                    49.14360964537143,
                    "Адорат",
                    3.8,
                    "Kazan",
                    "Russia",
                    "ул. Адоратского, 39 Б, к. 1"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    14,
                    55.78663391196758,
                    49.11198526729614,
                    "AutoFresh",
                    4.7,
                    "Kazan",
                    "Russia",
                    "ул. Галиаскара Камала, 4a"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    15,
                    55.79310295738006,
                    49.10344208437193,
                    "Автомойка Дельфин",
                    4.3,
                    "Kazan",
                    "Russia",
                    "ул. Рустема Яхина, 2Б"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    16,
                    55.77920831913687,
                    49.132050838892084,
                    "Автомойка Фабрика",
                    3.8,
                    "Kazan",
                    "Russia",
                    "Спартаковская ул.7"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    17,
                    55.81297737797303,
                    49.06423367313701,
                    "Автомойка CAR WASH",
                    3.9,
                    "Kazan",
                    "Russia",
                    "ул. 1 Мая, 5Б"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    18,
                    55.78248920630465,
                    49.20863420693283,
                    "Акваматик",
                    4.4,
                    "Kazan",
                    "Russia",
                    "пр-т. Победы, 141А"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    19,
                    55.74514781422196,
                    49.13597527429903,
                    "Автомойка на Кулагина",
                    4.0,
                    "Kazan",
                    "Russia",
                    "3, ул. Кулагина, 9"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    20,
                    55.800587269429926,
                    49.063376688831724,
                    "Автомойка на Жуковке",
                    4.0,
                    "Kazan",
                    "Russia",
                    "ул. Жуковка, 42"
                )
            )

            wiredLocationsList.add(
                MapCache(
                    21,
                    55.7854022799595,
                    37.580602474464946,
                    "TopClean",
                    4.5,
                    "Moscow",
                    "Russia",
                    "Б. Грузинская ул., 69"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    22,
                    55.807017696000806,
                    37.48378545664359,
                    "МосМойка",
                    4.4,
                    "Moscow",
                    "Russia",
                    "Маршала Бирюзова ул., д.32 к.1"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    23,
                    55.74406802549891,
                    37.50713140420335,
                    "Умная мойка 24 на Барклая",
                    4.0,
                    "Moscow",
                    "Russia",
                    "4.4, ул. Барклая, 1Б"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    24,
                    55.817820905416205,
                    37.66505987298997,
                    "Чистый город",
                    4.2,
                    "Moscow",
                    "Russia",
                    "Маломосковская ул., 22, строение 1"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    25,
                    55.76879658427228,
                    37.55039007174056,
                    "Аutocity24 Автомойка",
                    4.4,
                    "Moscow",
                    "Russia",
                    "Шмитовский пр-д, 16/2"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    26,
                    55.76995535079233,
                    37.678792783319246,
                    "Детейлинг центр",
                    4.8,
                    "Moscow",
                    "Russia",
                    "Каскад, наб. Академика Туполева, 15"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    27,
                    55.70694578298595,
                    37.49957830352225,
                    "Автомойка Аквастар",
                    4.0,
                    "Moscow",
                    "Russia",
                    "Мичуринский пр., 34"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    28,
                    55.652358481480164,
                    37.56343633574015,
                    "Автомойка N1",
                    4.5,
                    "Moscow",
                    "Russia",
                    "Севастопольский пр., 54Г"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    29,
                    55.68953257879589,
                    37.541463679213315,
                    "Moscow Auto Spa",
                    4.7,
                    "Moscow",
                    "Russia",
                    "ул. Панферова, 4"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    30,
                    55.741376986243274,
                    37.65833699613818,
                    "Чистомоем",
                    4.8,
                    "Moscow",
                    "Russia",
                    "Марксистская ул., 20, стр. 9 Въезд с ул. Марксистская"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    31,
                    55.76075632324311,
                    37.66863789368752,
                    "Автомойка-УмнаяМойка.рф",
                    4.7,
                    "Moscow",
                    "Russia",
                    "наб. Академика Туполева, вл.7"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    32,
                    55.716660332087535,
                    37.644597949706,
                    "Fast and Shine",
                    4.6,
                    "Moscow",
                    "Russia",
                    "Павелецкая наб., дом 2с2"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    33,
                    55.763769323237184,
                    37.552783820273966,
                    "GetWash",
                    4.8,
                    "Moscow",
                    "Russia",
                    "2-я Звенигородская ул., 13 строение 43"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    34,
                    55.78631105507544,
                    37.58691156548687,
                    "Автомойка на белорусской",
                    4.3,
                    "Moscow",
                    "Russia",
                    "1-я Ямского Поля ул., 30"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    35,
                    55.7731578672976,
                    37.60552713961594,
                    "автомойка Каспер",
                    4.6,
                    "Moscow",
                    "Russia",
                    "ул. Малая Дмитровка, 20"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    36,
                    55.770472823218114,
                    37.598844246154684,
                    "Маяк Мойка",
                    5.0,
                    "Moscow",
                    "Russia",
                    "Тверская ул., 28 к 2"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    37,
                    55.779992579055055,
                    37.6844434070668,
                    "SKT Автомойка",
                    4.6,
                    "Moscow",
                    "Russia",
                    "Налесный пер., 6"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    38,
                    55.77897842867658,
                    37.647316221170975,
                    "Core12",
                    4.3,
                    "Moscow",
                    "Russia",
                    "Каланчевская ул., 45, стр.4"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    39,
                    55.73979649576863,
                    37.6131523151274,
                    "SM24",
                    4.8,
                    "Moscow",
                    "Russia",
                    "ул. Большая Якиманка, 22к3"
                )
            )
            wiredLocationsList.add(
                MapCache(
                    40,
                    55.74172843877249,
                    37.507649125005756,
                    "Leisuwash",
                    4.8,
                    "Moscow",
                    "Russia",
                    "ул. Барклая, 6, стр. 5"
                )
            )
            wiredLocationsList.add(MapCache(41,33.96939660132926, -117.96343267207001, "Buff n Shine Express Car Wash", 4.3, "Los Angeles", "USA","W Whittier Blvd,La Habra"))
            wiredLocationsList.add(MapCache(42,34.00556330677624, -118.22514370694054, "Crystal Clean Car Wash", 4.1 , "Los Angeles", "USA","3003 E Gage Ave, Huntington Park"))
            wiredLocationsList.add(MapCache(43,34.01839043439768, -117.96806461783441, "Hacienda Express Car wash", 4.2, "Los Angeles", "USA","Gale Ave, Hacienda Heights"))
            wiredLocationsList.add(MapCache(44,33.95766284449441, -117.9720758230835,"Hacienda Express Car wash", 4.2, "Los Angeles", "USA","Hacienda Heights"))
            wiredLocationsList.add(MapCache(45,34.137042399685086, -117.857957641757, "Route 66 Car Wash", 4.1 , "Los Angeles", "USA","525 E Rte 66, Glendora"))
            wiredLocationsList.add(MapCache(46,34.04709263974865, -118.21921667350996, "100% Hand Car Wash", 4.2, "Los Angeles", "USA","Los Angeles, CA 90033"))
            wiredLocationsList.add(MapCache(47,34.05221293731688, -118.28753790508118, "Pico Car Wash", 3.9, "Los Angeles", "USA","W Pico Blvd, Los Angeles"))
            wiredLocationsList.add(MapCache(48,34.112779639080394, -118.19964727552225, "Highland Park Car Wash", 4.7, "Los Angeles", "USA", "N Figueroa St, Los Angeles"))
            wiredLocationsList.add(MapCache(49,34.10794726788676, -118.11587651922387, "Alhambra Hand Car Wash", 4.0, "Los Angeles", "USA","E Main St, Alhambra"))
            wiredLocationsList.add(MapCache(50,34.01095730913334, -118.28925451509313, "Westland Carwash", 3.0, "Los Angeles", "USA","S Vermont Ave, Los Angeles"))
            wiredLocationsList.add(MapCache(51,34.06444350673775, -118.34452948133921, "Expert Car Wash", 3.6, "Los Angeles", "USA","South La Brea Ave, Los Angeles"))
            wiredLocationsList.add(MapCache(52,34.03583959414586, -118.17506074728203, "Clement's Car Wash", 3.7, "Los Angeles", "USA","4247 E 3rd St"))
            wiredLocationsList.add(MapCache(53,34.064586135143074, -118.18228943145701, "Danny's Carwash and Detailing,",4.0, "Los Angeles", "USA","4635 E Valley Blvd, Los Angeles"))
            wiredLocationsList.add(MapCache(54,34.0512098530016, -118.2573607938922, "Eco Friendly Car Wash Express", 4.1,"Los Angeles", "USA","800 W 6th St level p1, Los Angeles"))
            wiredLocationsList.add(MapCache(55,34.07655029773848, -118.2873386850895, "LA's Best Self Car Wash", 4.1, "Los Angeles", "USA","3654 Beverly Blvd, Los Angeles"))

            wiredLocationsList.add(MapCache(56,51.50846012517276, -0.23182407968272264, "GoWashMyCar", 4.3, "London", "England" ,"44 Elvaston Pl, South Kensington"))
            wiredLocationsList.add(MapCache(57,51.568626310919996, -0.011969406635607962, "Alan Car Wash London", 4.5, "London", "England","453 High Rd Leyton"))
            wiredLocationsList.add(MapCache(58,51.46777250149895, -0.10808613728320254, "London valeting centre", 4.3, "London", "England","321-331 Coldharbour Ln"))
            wiredLocationsList.add(MapCache(59,51.52691805284179, -0.08141801521539833,"American Carwash", 2.5, "London", "England","35 Great Eastern St"))
            wiredLocationsList.add(MapCache(60,51.6170963596259, -0.10042807919558931, "Mobile Car Wash London - Smart Car Wash", 4.6, "London", "England","65 Tottenhall Rd"))
            wiredLocationsList.add(MapCache(61,51.596200511989565, -0.15158316971186125, "Fortis Green Ocean Car Valeting Service Ltd", 3.9,"London", "England", "Clissold Arms, 109 Fortis Green, Muswell Hill"))
            wiredLocationsList.add(MapCache(62,51.46576967376575, -0.12866336101212433, "Magic Hand Car Wash London", 3.1, "London", "England","21-25 Bedford Rd"))
            wiredLocationsList.add(MapCache(63,51.45256355093164, -0.14735364927454547, "Shell Car Wash", 3.4, "London", "England","London SW12 9DR"))
            wiredLocationsList.add(MapCache(64,51.52549849752214, -0.16979754331800503, "St Johns Wood Car Wash.",3.5, "London", "England","Q-Park Church Street, 10 Penfold St"))
            wiredLocationsList.add(MapCache(65,51.55906922329614, -0.013201452106429042, "IMO Car Wash", 3.6, "London", "England", "LEYTON MILLS, Marshall Rd"))


            wiredLocationsList.add(MapCache(66,48.83742004477999, 2.290370012243533, "Lavage a la main Paris ",4.2, "Paris", "France","22 Avenue de la Porte de la Plaine, 75015 Paris"))
            wiredLocationsList.add(MapCache(67,48.86227105246507, 2.2855634936715346, "Car Wash Luxury", 4.4, "Paris", "France","Boulevard de Grenelle, 75015 Paris"))
            wiredLocationsList.add(MapCache(68,48.830699924368716, 2.404663787577358,"Euro Car Wash", 3.8,  "Paris", "France","149 Rue de Paris, 94220 Charenton-le-Pont"))
            wiredLocationsList.add(MapCache(69,48.875849880153154, 2.3660117976507573, "Lavage a la main Paris 11", 4.8, "Paris", "France","50 Rue de Malte, 75011 Paris"))
            wiredLocationsList.add(MapCache(70,48.87639419796971, 2.3492422789393217, "Lavage a la main Paris 10", 4.5, "Paris", "France","5-7 Rue du Faubourg Poissonniere, 75010 Paris"))
            wiredLocationsList.add(MapCache(71,48.84815766842322, 2.300865152732047, "American Car Wash Paris 15", 4.0, "Paris", "France","26 Villa Croix Nivert, 75015 Paris"))
            wiredLocationsList.add(MapCache(72,48.88611749306218, 2.2867548425460216, "PARIS AUTO RENTAL washing car & motorcycle", 4.2,"Paris", "France","40 Boulevard Gouvion-Saint-Cyr, 75017 Paris"))
            wiredLocationsList.add(MapCache(73,48.84146888110964, 2.2556906799161633, "DC Lavage Auto & Moto Paris 16", 4.7, "Paris", "France","ACCES PAR LE PARKING INDIGO, 2 Avenue de la Porte de Saint-Cloud, 75016 Paris"))
            wiredLocationsList.add(MapCache(74,48.85514978581129, 2.2554149240083277, "Les Compagnons du Lavage", 3.8, "Paris", "France","136 Boulevard Suchet, 75016 Paris"))
            wiredLocationsList.add(MapCache(75,48.79154507712598, 2.3507416643157435, "Centre de lavage Novajet Villejuif", 4.1, "Paris", "France","88 Rue Auguste Perret, 94800 Villejuif"))
            wiredLocationsList.add(MapCache(76,48.806571080231976, 2.31062481683517, "Lavage auto karsher", 4.1, "Paris", "France","175 Avenue Henri Ravera, 92220 Bagneux"))


            wiredLocationsList.add(MapCache(77,35.71691103399745, 139.67666137502232, "Tokyo Auto Car Wash Nakano Store", 3.7, "Tokyo", "Japan","6 Chome-3-7 Nakano, Nakano City, Tokyo 164-0001"))
            wiredLocationsList.add(MapCache(78,35.76236472381249, 139.6283617636175, "Tokyo Auto Wash Nerima", 3.8, "Tokyo", "Japan","2 Chome-4-3 Takanodai, Nerima City, Tokyo 177-0033"))
            wiredLocationsList.add(MapCache(79,35.787921018826836, 139.75786072173184, "PitWash", 4.3, "Tokyo", "Japan","1 Chome-21-14 Shikahama, Adachi City, Tokyo 123-0864"))
            wiredLocationsList.add(MapCache(80, 35.78802871009596, 139.7583781167727, "Car Pika Land Shikahama", 4.0, "Tokyo", "Japan", "6 Chome-11-8 Shikahama, Adachi City, Tokyo 123-0864"))
            wiredLocationsList.add(MapCache(81,35.781406066599466, 139.7501166482108,"KeePer LABO Adachi Car Wash & Detailer", 3.8, "Tokyo", "Japan","1 Chome-13-7 Shikahama, Adachi City, Tokyo 123-0864"))
            wiredLocationsList.add(MapCache(82,35.703635462119905, 139.53505689714854, "KeePer LABO Mitaka", 3.7, "Tokyo", "Japan","4 Chome-225-3 Nozaki, Mitaka, Tokyo 181-0014"))
            wiredLocationsList.add(MapCache(83,35.600489016787684, 139.7427810594336, "Car Wash Ooi", 3.8, "Tokyo", "Japan","1 Chome-8 Katsushima, Shinagawa City, Tokyo 140-0012"))
            wiredLocationsList.add(MapCache(84,35.7395161768115, 139.50956651309514, "Shower Mate Hana-Koganei", 3.7, "Tokyo", "Japan","5 Chome-49 Hanakoganei, Kodaira, Tokyo 187-0002"))

            return wiredLocationsList
        }
    }
}