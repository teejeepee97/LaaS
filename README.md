# LaaS
Dit is onze readme file

**Roles** \
Product Owner - Daan, met hulp van Bryan \
Scrum Master - Vincent, Willem \
Developers - Thijs, Jodie, Daan, Bryan, Vincent, Willem

**Tools, frameworks, methodes**\
Vanuit hoofdstakeholder - Azure, Java17, Scrum, Spring \
Zelf bedacht - Miro, Figma \

# Important Links
- [UML Board + Naming Convention](https://miro.com/welcome/ZVpaVnBBWEdwaUpGSFdicEdJYUNTcmhXaE5QWURaektKY1JlRHRNM1RaYXRQajBlQzQxTFJlRTM1SWQ3bkpsM3wzNDU4NzY0NTk1MjEzMjczNDMxfDE=?share_link_id=747589087765)
- [Figma Wireframe of Frontend](https://www.figma.com/design/x1BJVGugJIE6LaH6gBwHM3/Figma-basics?node-id=663-257&t=H9rXsKOxWA448cgE-0)

# Product Goal
Om een schaalbaar duurzame leeromgeving te creëren waar users en trainers online toegang krijgen tot verschillende soorten Working Talent lesmateriaal. 

## Definition of Done
Om steeds een werkend product aan het einde van een week te crëeren, is het noodzekelijk aan de Definition of Done te houden.
- Alle functies, variables en classes moeten gedocumenteerd zijn met comments, in het engels. 
- Code peer reviewed door ten minste een ander persoon, view step 6 in Git Workflow.
- Code moet zonder conflict gemerged worden met main.

# Sprint #1 
**Sprint Goal** — een eerste versie van het product, in de frontend een tabel van de backend kan zien. Eerste mockup van de frontend te kunnen laten zien.


**Priorisations** \
 (P0) - Moet gedaan worden om verder te kunnen gaan. \
 (P1) - Eerste dat opgepakt moet worden als huidige taken af zijn. \
 (P2) - Alles dat gedaan moet worden op de backlog. \
 (P3) - Alles dat niet relevant is voor het project op dit moment.

## Git Branching Protocol
1. Main Branch - Dit is de stabiele branch die altijd in 'production-ready' staat blijft.
2. Feature Branch - Elke nieuw feture, bug fix moet gemaken in zijn eigen branch

### Naming Convention
 - featName; dus featVincent bijvoorbeeld.



## Git Workflow
### 0. Cloning the repository (First time use)
   
First, clone the repository to your local machine:
```
git clone https://github.com/your-username/your-repository.git
cd [your-repository]
```
### 1. Creating a Branch
Create a new branch for your work based on the latest main branch:
```
git checkout main
git status main
git pull origin main
git checkout -b feature/short-description
```

### 2. Making Changes

Make your changes in the new branch. Frequently commit your changes with clear and concise messages:
```
git add .
git commit -m "Add detailed description of the changes made"
```

### 3. Pushing Changes
Push your branch to the remote repository:
```
git push -u origin featVincent
```

### 4. Creating a Pull Request

1. Go to the [repository on GitHub](https://github.com/teejeepee97/LaaS).
2. Navigate to the "Pull requests" tab.
3. Click "New pull request".
4. Select your branch from the compare dropdown.
5. Provide a clear title and description for the pull request.
6. Request reviews from relevant team members.
7. Submit the pull request.

### 5. (Optional for now) Code Review

Team members will review the pull request and provide feedback. Make any necessary changes in your feature branch:
```
git checkout feature/short-description
git add .
git commit -m "Address review feedback"
git push origin feature/short-description
```

### 6. Merging to Main
Once the pull request is approved and all checks pass, it can be merged into the main branch. This is usually done by a maintainer or a team lead to ensure consistency:
```
Merge the pull request on the GitHub interface.
Delete the feature branch if it’s no longer needed.
```

### 7. Update you local main branch
After a successful merge, update your local main branch:
```
git checkout main
git status main
git pull origin main
```

### Troubleshooting
If you encounter merge conflicts when updating your branch, resolve them locally:
```
git fetch origin
git merge origin/main
# Resolve conflicts manually
git add .
git commit -m "Resolve merge conflicts"
git push origin [featVincent]
```
## Resetting a failed feature branch ##
If you run into issue with your feature branch conflicting with the main, it may be time to reset the feature branch to the main. To do this, save the important changes to a serperate file to copy later. 
**WARNING: This will reset all changes and remove all files including .gitignore files in your local repository.**
```
git reset             // This will unstage all files you might have staged with git add .
git checkout main     // This will revert local uncommited changes (execture in main)
// Alternatively
git reset --hard main // This will revert all uncommitted changes (works from any directory)

git clean -n          // Preview of files to be deleted
git clean -fdx        // Removes all non-committed data, even what is in .gitignore
```
