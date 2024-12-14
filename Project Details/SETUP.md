# Project Setup

## Clone a GitHub Repository

In 2110215 PROG METH course, there will be a repository for your teams in the subject's GitHub organization. All you needed to do is clone the repository into your computer.

**Step 1:** Open your terminal. You can use both Command Prompt and git bash.

**Step 2:** Change the path to your project folder path by using the command line below on your terminal.

```
cd [INSERT YOUR PROJECT FOLDER PATH HERE]
```

For example.

```
cd "C:\Users\Worralop\Documents\PROG METH"
```

> [!IMPORTANT]
> If your folder name has a whitespace, a symbol `"` at the front and the end of the folder path is needed.

**Step 3:** Clone your repository into your computer.

First, copy your GitHub repository HTTPS URL link from GitHub website. You can get it from here.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/GitClone.png" height=80% width=80%>

Then, use the command line below on your terminal.

```
git clone [INSERT REPO HTTPS URL HERE]
```

For example.

```
git clone https://github.com/2110215-ProgMeth/project-2024-term-1-steve.git
```

> [!TIP]
> If `git clone` is not working, you may haven't setup your GitHub configuration yet. Please setup your GitHub configuration first.
>
> [**>> How to setup GitHub configuration? <<**](https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/GitClone.png)

## Setup Java Project on Eclipse

### Download JavaFX

This project uses JavaFX for Graphical User Interface (GUI), so if you haven't download this on your computer yet, please download it.

**Link:** https://gluonhq.com/products/javafx/

> [!NOTE]
> It seems like JavaFX version `23.0.1` is sometimes not working with the project. It is better to download a long-term support (LTS) version instead, such as JavaFX version `21.0.5 (LTS)`.

### Setup Java Runtime Environment (JRE) for Project

This step is a little complicated, but it is necessary to setup this before starting a project.

**Step 1:** Open Eclipse, then go to the upper left corner, click on `File` > `New` > `New Java Project`.

**Step 2:** Remove a tick on `Create module-info.java file` box, then click on `Configure JREs`.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/NewProject.png" height=80% width=80%>

**Step 3:** Click on the installed Java Development Kit (JDK), then click `Duplicate`.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/JRE01.png" height=80% width=80%>

> [!NOTE]
> Java JDK 22 is recommended for this project.

**Step 4:** Rename `JRE name`, then add `Default VM arugment` to the command line below.

```
--module-path [PATH TO JavaFX lib FOLDER] --add-modules javafx.controls,javafx.graphics,javafx.media,javafx.fxml
```

For example.

```
--module-path "C:\Users\Worralop\eclipse\javafx-sdk-21.0.5\lib" --add-modules javafx.controls,javafx.graphics,javafx.media,javafx.fxml
```

Here is what it should look like after finishing this step.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/JRE02.png" height=80% width=80%>

**Step 5:** Add JavaFX JAR files to the JRE, by clicking on `Add External JARs`.

Go to the JavaFX's `lib` folder, and add all of them.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/JRE03.png" height=80% width=80%>

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/JRE04.png" height=80% width=80%>

Make sure to select JRE to the one with JavaFX, then click `Apply and Close`.

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/JRE05.png" height=80% width=80%>

And now your Eclipse Java project setup is finally done!

---

# Working on GitHub

## Important GitHub Commands

In 2110215 PROG METH course, we need to use GitHub to working on this project with the teams. You must know these GitHub command to working on this

### GitHub Configuration (`git config`)

If the `git` command line doesn't work, you may haven't setup your configuration yet. Please try using these command lines.

```
git config --global user.name [YOUR GITHUB USERNAME]
git config --global user.email [YOUR EMAIL]
git config --global user.password [YOUR GITHUB PASSWORD]
```

> [!IMPORTANT]
> For email configuration, You need to use an email that used to register your GitHub account.

### Check status (`git status`)

Before going to explain about `git status`, we need to understand about simple thing first.

- **Repository** is where we store a code.
- **Local Repository** is a repository in a computer.
- **Remote Repository** is a repository in a GitHub website.

To check status between local repository and remote repository, you can simply use the command below.

```
git status
```

By using this command, it returns information as the following.

- Current branch status compared to `origin/main`.
- Change staged to commit.
- Modified/Created/Deleted files on local repository compared to the remote repository.

### Push Updates (`git add` / `git commit` / `git push`)

When you make changes to the code, you need to push the changes from you local repository to the remote repository so your friends can pull your updates into their local repository.

**Step 1:** Use `git add` to stage the updates you want to push to the remote repository.

If you want to stage all change you have made, just simply use.

```
git add .
```

If you want to stage a specific file or folder, you need to use.

```
git add [FILE/FOLDER PATH]
```

For example

```
git add Main.java
git add /MINDsweeper/src/application/Main.java
git add /MINDsweeper/res
```

> [!TIP]
> If you want to ignore the changes on a specific file or folder. Add their path to the `.gitignore` file.

**Step 2:** Use `git commit` to create a commit for the folder and files added.

You can simply use the command.

```
git commit -m [COMMIT MESSAGE]
```

The commit message can be anything. It is like a topic for the updates, for example.

```
git commit -m "fix: image not showing"
```

### Pull Updates (`git pull`)

When your friends make changes to the code and push their changes to the remote repository on GitHub, you need to pull the updates from the remote repository before continue your work.

It's just simple, just use this command.

```
git pull
```

> [!WARNING]
> When your teams make changes to the same file, the merge conflicts occurs.
>
> There are several solution to solve the merge conflicts depends what file version you prefer, but I recommend to communicate with your team to prevent this from happening.

## Using GitHub Desktop (Optional)

**GitHub Desktop** is another way to use GitHub but a lot easier. You can easily `git add`, `git commit`, `git push` and `git pull` without any command line.

I highly recommend using GitHub Desktop for those who not familiar with the command line.

[**>> Download GitHub Desktop <<**](https://desktop.github.com/download/)

<img src="https://raw.githubusercontent.com/reisenx/PROG-METH-I-PROJECT/refs/heads/main/Project%20Details/Others/GitHubDesktop.png">
