package bots

import com.vdurmont.emoji.EmojiParser
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendAudio
import org.telegram.telegrambots.meta.api.methods.send.SendDocument
import org.telegram.telegrambots.meta.api.methods.send.SendMessage


import org.telegram.telegrambots.meta.api.objects.InputFile
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.io.File
import kotlin.random.Random

class WCCBot : TelegramLongPollingBot() {

    override fun getBotUsername(): String {
        //return bot username
        // If bot username is @HelloKotlinBot, it must return
        return "WCC-MAY-BOT"
    }

    override fun getBotToken(): String {
        // Return bot token from BotFather
        return ""
    }

    override fun onUpdateReceived(update: Update?) {
        // We check if the update has a message and the message has text
        val nameSender = update?.message?.from?.firstName
        val chatId = update?.message?.chatId.toString()
        val messageCommand = update?.message?.text?.lowercase()


        try {

            when (messageCommand) {
                "/pedra" -> {
                    var escolha: String = getOpcao()
                    if (escolha == "pedra") {
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = empatou(nameSender, escolha)
                            this.document =
                                InputFile().setMedia("https://media.giphy.com/media/ECgGYKyCToaGY/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    } else if (escolha == "papel") {
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = perdeu(nameSender, escolha)
                            this.document =
                                InputFile().setMedia("https://media.giphy.com/media/nDSlfqf0gn5g4/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    } else if (escolha == "tesoura") {
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = ganhou(nameSender, escolha)
                            this.document =
                                InputFile().setMedia("https://media.giphy.com/media/ju40gZCQw9azC/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }
                }

                "/papel" -> {
                    var escolha: String = getOpcao()
                    if(escolha == "papel"){
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = empatou(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/ECgGYKyCToaGY/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }

                    else if(escolha == "tesoura"){
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = perdeu(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/nDSlfqf0gn5g4/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }

                    else if(escolha == "pedra") {
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = ganhou(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/ju40gZCQw9azC/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }
                }

                "/tesoura" -> {
                    var escolha: String = getOpcao()
                    if(escolha == "tesoura"){
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = empatou(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/ECgGYKyCToaGY/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }

                    else if (escolha == "pedra"){
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = perdeu(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/nDSlfqf0gn5g4/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }

                    else if (escolha == "papel") {
                        val sendDocument = SendDocument().apply {
                            this.chatId = chatId
                            this.caption = ganhou(nameSender, escolha)
                            this.document = InputFile().setMedia("https://media.giphy.com/media/ju40gZCQw9azC/giphy.gif")
                            this.parseMode = "MarkdownV2"
                        }
                        execute(sendDocument)
                    }

                }

                "/jogar" -> {

                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = getMessage(messageCommand, nameSender)
                        this.document = InputFile().setMedia("https://media.giphy.com/media/GWNBoSxSpt7Ik/giphy.gif")
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)
                }

                "/start" -> {

                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = getMessage(messageCommand, nameSender)
                        this.document = InputFile().setMedia("https://media.giphy.com/media/rOEvmLAxxcE1i/giphy.gif")
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)
                }

                "/info" -> {

                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = getMessage(messageCommand, nameSender)
                        this.document = InputFile().setMedia("https://media.giphy.com/media/gPBKtKGk00TfD3D6mY/giphy.gif")
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)
                }

                else -> {

                    val sendDocument = SendDocument().apply {
                        this.chatId = chatId
                        this.caption = getMessage(messageCommand, nameSender)
                        this.document = InputFile().setMedia("https://media.giphy.com/media/xTeWOVI8shjIDTq9Yk/giphy.gif")
                        this.parseMode = "MarkdownV2"
                    }
                    execute(sendDocument)
                }

            }
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

    private fun getOpcao(): String {
        val list = arrayListOf<String>("pedra", "papel", "tesoura")
        return list.get(Random.nextInt(0,3))
    }

    private fun getMessage(command: String?, nameSender: String?) = when(command) {
        "/info" -> info()
        "/start" -> welcome(nameSender)
        "/jogar" -> comecar(nameSender)
        else -> EmojiParser.parseToUnicode("Escolha uma opção válida :weary:")
    }

    private fun comecar(nameSender: String?) = """
        |*$nameSender, vamos começar\?*
        |\Escolha uma opção: \
        |\/pedra \
        |\/papel \
        |\/tesoura 
    """.trimMargin()


    private fun welcome(nameSender: String?) = """
        |*Oláaaa $nameSender, tudo bemm\?*
        |\Você quer jogar:
        |
        |*PEDRA PAPEL TESOURA\?*\
        |
        |\/start \- começar o projeto
        |\/jogar \- para começar a jogar        
        |\/info \- para saber mais sobre o projeto
    """.trimMargin()


    private fun ganhou(nameSender: String?, escolha: String?) = """
        |*Parabéns $nameSender, você ganhou\!\!*
        |Eu escolhi *${escolha?.uppercase()}*, e por isso você ganhou\!\!
    """.trimMargin()

    private fun perdeu(nameSender: String?, escolha: String?) = """
        |*Ops $nameSender, eu ganhei\!\!*
        |Eu escolhi *${escolha?.uppercase()}*, e por isso eu ganhei\!\!
    """.trimMargin()

    private fun empatou(nameSender: String?, escolha: String?) = """
        |*$nameSender, nós empatamos\!\!*
        |Eu escolhi *${escolha?.uppercase()}* e você também\!\!
    """.trimMargin()

    private fun info() = """
        |Bot criado por Mayara Veloso Lima durante as aulas do projeto
        |Woman Can Code \- trilha Stilingue
        |GitHub: https://github\.com/mayvlima/wcc\-kotlin\-telegram\-bot
    """.trimMargin()

}

