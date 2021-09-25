### Google OAuth configuration

1. Navigate to google console -> API & Services -> Credential
2. Create Credential ->  Create OAuth client ID
3. Provide 	App type -> Web app, Name, URIs - http://localhost:9191(App URI), 
   Authorized redirect URIs - http://localhost:9191/login/oauth2/code/google(Google auth service URI)
4. Once you hit on create credential, we will get client ID & Secret. Copy it. 