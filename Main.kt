enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("O usuário ${usuario.nome} foi matriculado na formação $nome.")
        } else {
            println("O usuário ${usuario.nome} já está matriculado na formação $nome.")
        }
    }
}

fun main() {
    val usuario1 = Usuario("usuario1")
    val usuario2 = Usuario("usuario2")
    val usuario3 = Usuario("usuario3")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Kotlin Avançado", 90)

    val formacaoKotlin = Formacao("Kotlin")
    formacaoKotlin.conteudos.addAll(listOf(conteudo1, conteudo2))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario1) // Tentando matricular o mesmo usuário novamente

    println()

    println("Inscritos na Formação ${formacaoKotlin.nome}:")
    for (inscrito in formacaoKotlin.inscritos) {
        println(inscrito.nome)
    }
}
