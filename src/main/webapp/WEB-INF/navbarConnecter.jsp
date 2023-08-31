  
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
        <div class="col-md-5">
            <ul class="navbar-nav">
            	<li class="nav-item">
                    <a class="nav-link" href="<c:url value='/IndexServlet' />">Accueil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/ServletAfficherArticle' />">Enchères</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/ServletCreateArticle' />">Vendre un Article</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/ServletMonProfil' />">Mon Profil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value='/ServletDisconectUser' />">Déconnexion</a>
                </li>
            </ul>
        </div>
        </div>
    </div>
</nav>

