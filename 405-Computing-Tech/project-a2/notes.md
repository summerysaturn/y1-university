# CI405 A2 notebook

Charlotte Ward | CI405 Assignment 2 | Year 1 CSG

* [CI405 A2 notebook](#ci405-a2-notebook)
  * [Week 1 Questions](#week-1-questions)
  * [Week 1 Lab Work](#week-1-lab-work)
    * [Step 0:](#step-0)
    * [Step 1: Creating a VM and allocating resources](#step-1-creating-a-vm-and-allocating-resources)
    * [Step 2: Install the operating system using the ISO](#step-2-install-the-operating-system-using-the-iso)
    * [Step 3: Create a user account and apply updates](#step-3-create-a-user-account-and-apply-updates)
  * [Week 2 Questions](#week-2-questions)
  * [Week 2 Lab Work](#week-2-lab-work)
  * [Week 3 Questions](#week-3-questions)
  * [Week 3 Lab Work](#week-3-lab-work)
  * [Week 4 Questions](#week-4-questions)
  * [Week 4 Lab Work](#week-4-lab-work)
  * [Week 5 Questions](#week-5-questions)
  * [Week 5 Lab Work](#week-5-lab-work)

## Week 1 Questions

| Question 1: Define the four main components of a computer. |
| :--------------------------------------------------------- |

Input, Processor, Memory, Output.

Other components can be added in to optimise this, but the core concept of a computer (vs. a Turing machine or similar) revolves around Input and Output.

| Question 2: Explain the difference between a fixed program computer and a stored program computer. |
| :------------------------------------------------------------------------------------------------- |

Fixed program computers have a set operation and control flow, whereas stored program computers can be modified before, during and after execution. Fixed program computers can be very simple and cheap, whereas stored program computers are more complex but more versatile. Most modern computers are stored program computers, whereas IOT devices and chipsets are often stored program computers.

| Question 3: What is Gordon Bell’s law about the near future of computer class? |
| :----------------------------------------------------------------------------- |

Gordon Bell's law determines the scale and ubiquity of computer systems, explaining how computers are getting smaller and more prolific in society. He describes that Mainframe computers were initially the most important,

## Week 1 Lab Work

```plaintext
Task: instructions to install Fedora on Virtual Box

Step 0: Download Fedora from https://getfedora.org/en/workstation/ & install VirtualBox (apt)
Step 1: Creating a VM and allocating resources
Step 2: Install the operating system using the ISO
Step 3: Create a user account and apply updates
```

### Step 0:

I already have VirtualBox installed on my operating system as it's useful for trying out other Linux distributions and emulating various operating systems. I downloaded the Fedora ISO from the website easily and have it ready in my Downloads folder.

### Step 1: Creating a VM and allocating resources

![VirtualBox Main View](img/lab1-001.png)
![Setting up the Operating System with a name and type](img/lab1-002.png)
![Setting memory to 4096MB](img/lab1-003.png)
![Setting the disk type to VMDK for Compatibility](img/lab1-004.png)
![Setting the VMDK disk to 16GB](img/lab1-005.png)
![The new home screen for VirtualBox](img/lab1-006.png)
![Setting a boot disk for Fedora](img/lab1-007.png)
![Selecting the ISO from my Downloads folder](img/lab1-008.png)
![Here it is properly set up as a Live CD](img/lab1-009.png)
![On boot it asks for a start-up disk, set that to Fedora](img/lab1-010.png)

### Step 2: Install the operating system using the ISO

![Freshly launched](img/lab1-011.png)
![Here's the live disk bootloader](img/lab1-012.png)
![Linux boot screen](img/lab1-013.png)
![Fedora uses a fairly stock Gnome Linux installer - Install to Disk](img/lab1-014.png)
![Set the keyboard language to English US](img/lab1-015.png)
![Set the hard disk to the VBOX Hard Drive](img/lab1-016.png)
![Everything seems ok, ready to begin](img/lab1-017.png)
![All installed on disk](img/lab1-018.png)
![Now to reboot](img/lab1-019.png)
![Almost ready to reboot](img/lab1-020.png)
![Disconnect the Live CD](img/lab1-021.png)

### Step 3: Create a user account and apply updates

Select the correct bootloader in... looks like systemd-boot?
![Select the correct bootloader in... looks like systemd-boot?](img/lab1-022.png)
Booting nice and quickly
![Booting nice and quickly](img/lab1-023.png)
All okay! Fedora setup looks a lot like Ubuntu
![All okay! Fedora setup looks a lot like Ubuntu](img/lab1-024.png)
Turn off tracking and such
![Turn off tracking and such](img/lab1-025.png)
Set up the user name
![Set up the user name](img/lab1-026.png)
Set up the user password
![Set up the user password](img/lab1-027.png)
Now to apply updates
![Now to apply updates](img/lab1-028.png)
Fedora has a nice stock Gnome experience
![Fedora has a nice stock Gnome experience](img/lab1-029.png)
Lovely old bash
![Lovely old bash](img/lab1-030.png)
Starting the sudo dnf upgrade
![Starting the sudo dnf upgrade](img/lab1-031.png)
1.1GiB is a lot of data, 800+ packages. Wow.
![1.1GiB is a lot of data, 800+ packages. Wow.](img/lab1-032.png)
9 minutes of execution time. wow.
![9 minutes of execution time. wow.](img/lab1-033.png)

## Week 2 Questions

| Question 1: Explain Moore’s law. Is Moore’s law a Physics law? |
| :------------------------------------------------------------- |

| Question 2: Modern CPUs are measured in nano-metre scale (e.g. 14 nm CPU). What does this number mean? Is this the size of each individual transistor? |
| :----------------------------------------------------------------------------------------------------------------------------------------------------- |

| Question 3: Describe the quantum tunneling problem in the transistor design. |
| :--------------------------------------------------------------------------- |

## Week 2 Lab Work

```plaintext
Task: Performing the following Linux commands, using one of the environments we set up in Week 1.

$ date
$ date > today
$ cat today
$ date >> today
$ cat today
$ cal 1 2010
$ ls
$ ls -l
$ ls -l > files
$ cat *
$ cat p*
$ mkdir mysub
$ ls
$ cd mysub
$ cd ..
$ pwd
$ cd .
$ cd ~
$ ls ~/mysub
$ ls ~
$ ls ~/..
$ cp today tomorrow
$ cd ~/mysub
$ cp ~/tomorrow .
$ ls
$ mv tomorrow files.txt
$ rm files.txt
```

Date, Cat and basic redirection operators
![Date, Cat and basic redirection operators](img/lab2-001.png)
Calendar and Who commands
![Calendar and Who commands](img/lab2-002.png)
ls, ls -l commands
![ls, ls -l commands](img/lab2-003.png)
ls with redirection operators
![ls with redirection operators](img/lab2-004.png)
cat with wildcard operator
![cat with wildcard operator](img/lab2-005.png)
cat with wildcard operator (cont.)
![cat with wildcard operator (cont.)](img/lab2-006.png)
pwd, cd, directory handling
![pwd, cd, directory handling](img/lab2-007.png)
Moving and removing files
![Moving and removing files](img/lab2-008.png)

## Week 3 Questions

| Question 1: What is RowHammer? What are the potential solutions? |
| :--------------------------------------------------------------- |

| Question 2: Comparing the three levels of cache. |
| :----------------------------------------------- |

| Question 3: Explain the differences between RAID 1, 5 and 10. |
| :------------------------------------------------------------ |

| Question 4: Describe the concept of processing in memory. |
| :-------------------------------------------------------- |

## Week 3 Lab Work

```plaintext
Task: Performing the following Linux commands, using one of the environments we set up in Week 1.

$ ps -ef
$ sleep 10 &
$ sleep 1000 (then ctrl+z)
$ bg
$ jobs
$ fg %1

$ sleep 100 (then ctrl+c)
$ sleep 100 &
$ jobs
$ kill %1

$ sleep 1000 &
$ ps
$ kill (pid)
$ kill -9 (pid)

$ vi
  Enter the text: "The quick fox jumps over the lazy dog"
  Find a way to save this text into a file “viFile.txt” without quitting.
  Find a way to quit the editor now.
  List the content of this file with the more and the cat commands.

$ wget https://gutenberg.org/files/1661/1661-0.txt
$ head -20 1661-0.txt
```

Basic background processes
![Basic background processes](img/lab3-01.png)
Ctrl+Z Operator & bg
![Ctrl+Z Operator & bg](img/lab3-02.png)
Jobs & killing based on job list
![Jobs & killing based on job list](img/lab3-03.png)
ps command & killing based on pid
![ps command & killing based on pid](img/lab3-04.png)
vi editing
![vi editing](img/lab3-05.png)
Writing the vi editor to out (viFile.txt)
![Writing the vi editor to out (viFile.txt)](img/lab3-06.png)
Writes ok...
![Writes ok...](img/lab3-07.png)
Force quit
![Force quit](img/lab3-08.png)
Quit ok...
![Quit ok...](img/lab3-09.png)
cat the file
![cat the file](img/lab3-10.png)
more the file
![more the file](img/lab3-10.png)
wget from the directory provided
![wget from the directory provided](img/lab3-12.png)
Showing the file using less
![Showing the file using less](img/lab3-14.png)
Showing the first 20 lines using head -20
![Showing the first 20 lines using head -20](img/lab3-15.png)
Showing the first 20 lines using head -20
![Showing the first 20 lines using head -20](img/lab3-16.png)

## Week 4 Questions

| Question 1: Explain the difference between a digital sensor and an analog sensor. |
| :-------------------------------------------------------------------------------- |

| Question 2: Describe the responsibilities of the “Cloud processing unit” (the top layer of IoT). |
| :----------------------------------------------------------------------------------------------- |

| Question 3: Explain the difference between a microcontroller (e.g. Arduino) and an embedded board (e.g. Raspberry Pi). |
| :--------------------------------------------------------------------------------------------------------------------- |

## Week 4 Lab Work

![](img/lab4-001.png)
![](img/lab4-002.png)
![](img/lab4-003.png)
![](img/lab4-004.png)
![](img/lab4-005.png)
![](img/lab4-006.png)

## Week 5 Questions

| Question 1: Describe the challenges facing mobile computing technology. |
| :---------------------------------------------------------------------- |

| Question 2: What is context awareness? Give one example of a context awareness mobile app. |
| :----------------------------------------------------------------------------------------- |

| Question 3: What are the challenges for doing Augmented Reality on a mobile device? |
| :---------------------------------------------------------------------------------- |

## Week 5 Lab Work

![](img/lab5-001.png)
![](img/lab5-002.png)
![](img/lab5-003.png)
![](img/lab5-004.png)
![](img/lab5-005.png)
![](img/lab5-006.png)
![](img/lab5-007.png)
