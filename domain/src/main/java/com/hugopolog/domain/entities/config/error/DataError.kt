package com.hugopolog.domain.entities.config.error

sealed interface DataError : RootError {

    //TODO() Right now those are just examples, we need to define the actual errors
    sealed class Generic : DataError {

        data object NetworkError : Generic() // Problemas de conectividad
        data object ServerError : Generic() // Error en el servidor (500)
        data object UnknownError : Generic() // Error desconocido o no mapeado
        data object NoData : Generic() // Sin datos en la respuesta
        data object BadRequest : Generic() // Error 400, petición mal formada
        data object Unauthorized : Generic() // Error 401, no autenticado
        data object Forbidden : Generic() // Error 403, no autorizado
        data object NotFound : Generic() // Error 404, no encontrado
        data object Conflict : Generic() // Error 409, conflicto (ej: datos duplicados)
        data object Timeout : Generic() // Error por timeout en la conexión
    }

    sealed class Lessons : Generic() {
        data object LessonAlreadyFull : Lessons()
        data object PlayerAlreadyInLesson : Lessons()
        data object LessonDetailNotFound : Lessons()
        data object ThumbnailsNotReady : Lessons()
    }

    sealed class UserAuth : Generic() {

        data object InvalidCredentials : UserAuth()

        data object UserNotFound : UserAuth()

        data object EmptyFields : UserAuth()

        data object InvalidEmailFormat : UserAuth()

        data object WrongVerificationCode : UserAuth()

        data object TooManyVerificationAttempts : UserAuth()

        data object UserAlreadyExists : UserAuth()

        data object UserNotVerified : UserAuth()
        data object UserDoesNotExist : UserAuth()
        data object WrongPassword : UserAuth()
        data object InvalidEmail : UserAuth()

        data object EmailNotFound : UserAuth()
    }

    sealed class MicrophoneRecordingError : Generic() {
        data object MicrophonePermissionNotGranted : MicrophoneRecordingError()

        data object StartFailed : MicrophoneRecordingError()
        data object StopFailed : MicrophoneRecordingError()
        data class RecognitionFailed(val message: String) : MicrophoneRecordingError()
        data object AudioError : MicrophoneRecordingError()
        data object ClientError : MicrophoneRecordingError()
        data object InsufficientPermissions : MicrophoneRecordingError()
        data object NetworkError : MicrophoneRecordingError()
        data object NetworkTimeoutError : MicrophoneRecordingError()
        data object NoMatchError : MicrophoneRecordingError()
        data object RecognizerBusyError : MicrophoneRecordingError()
        data object ServerError : MicrophoneRecordingError()
        data object SpeechTimeoutError : MicrophoneRecordingError()
        data object UnknownError : MicrophoneRecordingError()
    }

    sealed class Test : Generic() {
        data object TestError : Test()
    }
}
