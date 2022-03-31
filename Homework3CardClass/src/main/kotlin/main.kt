import com.company.Card

fun main(args: Array<String>) {
    val kingCard: Card = Card(Card.Companion.Rank.King, Card.Companion.Suit.Clubs);
    val kingCard1: Card = Card(Card.Companion.Rank.King, Card.Companion.Suit.Clubs);
    val kingCard2: Card = Card(Card.Companion.Rank.King, Card.Companion.Suit.Spades);
    val queenCard: Card = Card(Card.Companion.Rank.Queen, Card.Companion.Suit.Clubs);
    println("${kingCard} equals ${kingCard1} is ${kingCard == kingCard1}")
    println("${kingCard} equals ${queenCard} is ${kingCard == queenCard}")
    println("${kingCard} stronger than ${queenCard} is ${kingCard > queenCard}")
    println("${kingCard} weaker than ${kingCard2} is ${kingCard < kingCard2}")

}