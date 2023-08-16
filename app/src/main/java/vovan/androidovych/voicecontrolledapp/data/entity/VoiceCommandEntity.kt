package vovan.androidovych.voicecontrolledapp.data.entity

enum class VoiceCommandEntity(val keyWords: Set<String>, var params: String? = null) {
    START(setOf("start", "begin")),
    STOP(setOf("stop", "finish", "end", "cancel")),
    NEXT(setOf("next", "go")),
    BACK(setOf("back", "previous")),
    ALLOW(setOf("ok", "okay", "yes", "sure")),
    DISALLOW(setOf("no", "not")),
    EXIT(setOf("exit", "terminate")),
    SETTINGS(setOf("settings", "setup", "configurations")),
    AUTH(setOf("auth", "singIn", "authorize", "enter", "login")),
    ABOUT(setOf("describe yourself", "who are you", "what can you do")),
    HELP(setOf("help", "help me", "help i want somebody")),
    BACKGROUND(setOf());

    companion object {
        fun processCommand(output: String): VoiceCommandEntity =
            values().firstOrNull { command ->
                command.keyWords.firstOrNull { word -> output.trim().contains(word) } != null
            }?.applyParams(output) ?: BACKGROUND

        fun getAllCommands() = values().flatMap { set -> set.keyWords.map { it } }
    }
}

fun VoiceCommandEntity.isIn(text: String): Boolean =
    keyWords.sumOf { if (text.contains(it)) 1.toInt() else 0 } > 0


fun VoiceCommandEntity.applyParams(text: String): VoiceCommandEntity = this.apply {
    params = text
    keyWords.forEach { params = params?.replace(it, "", true) }
}

