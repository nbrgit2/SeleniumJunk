$FirefoxUpload = "File upload"
$IEUpload="Choose File Upload"
If WinExists($FirefoxUpload) Then
Send("lib\TestImage.jpg")
Send("{ENTER}")
ElseIf WinExists($IEUpload) Then
Send("lib\TestImage.jpg")
Send("{ENTER}")
Else
Send("lib\TestImage.jpg")
Send("{ENTER}")
EndIf

