# Report from Controlled Experiment: Code Review Solo vs. Pairs

**Authors:**

Szymon Haj, 153059

Marcin Stecewicz

Poznan, 22. 12.2025

---

## Introduction

This report presents the design and summarizes results of the experiment **"Code Review Solo vs. Pairs:  A Comparative Study of Defect Detection Effectiveness"**. The experiment was part of a project realized within the Quality Management and Experimental Software Engineering classes at Poznan University of Technology.

The motivation for this study stems from the ongoing debate in software engineering about the effectiveness of pair programming and collaborative code review practices. While pair programming has been studied extensively, the specific context of code review—where developers systematically examine code to find defects—presents unique characteristics that warrant separate investigation.  Understanding whether working in pairs improves defect detection during code review has practical implications for software development teams seeking to optimize their quality assurance processes.

---

## Experiment Definition

The goal of the experiment was to:  

- **Object of study**:  Code review process performed by students
- **Purpose**: Compare and evaluate
- **Quality focus**: Defect detection effectiveness (number of defects found, false positive rate, and time efficiency)
- **Perspective**: From the viewpoint of software developers and quality assurance practitioners
- **Context**: Conducted with 5th-year Computer Science students at Poznan University of Technology in a controlled laboratory setting

**Research Questions:**

- RQ1: Does pair code review result in more defects being detected compared to solo code review?
- RQ2: Is solo code review faster in terms of defect detection speed?  

---

## Experiment Design

### Hypotheses

The following hypotheses were formulated a priori:

**H1 (Defect Detection):**
- H1₀: There is no significant difference in the number of defects found between solo and pair code review (μ_pair = μ_solo)
- H1₁:  Pairs find significantly more defects than individuals working solo (μ_pair > μ_solo)


### Variables and Confounding Factors

**Independent Variable:**
- **Work mode**:  Categorical variable with two levels
  - Solo: Individual code review
  - Pair: Two-person collaborative code review

**Dependent Variables:**

1. **Number of defects found**:  Continuous variable (0-10 scale)
   - Measurement: Count of valid defects reported by participant/pair
   
2. **False positive rate**:  Continuous variable (0-1 scale)
   - Calculation: FP / (True Positives + FP)

**Controlled Confounding Factors:**

1. **Programming experience**: Controlled through demographic survey; all participants are 5th-year Computer Science students with similar educational background

2. **Learning effect**: Controlled through counterbalancing design—half of participants start with solo review, half start with pair review

3. **Code difficulty**: Controlled by using two code samples (Code 1: tree_and_binary_search. java, Code 2: graph_algorithms.java) with similar characteristics:  
   - Code 1 contains 14 true defects
   - Code 2 contains 29 true defects
   - Similar lines of code (~200-500 LOC each)
   - Both represent realistic programming scenarios

4. **Order effects**: Mitigated through counterbalancing—Group 1 reviews Code 1 then Code 2, Group 2 reviews Code 2 then Code 1

5. **Fatigue**:  Controlled through 5-minute break between sessions and limiting each session to 30 minutes

**Uncontrolled/Measured Confounding Factors:**

1. **Pair dynamics**: Measured through post-experiment survey questions about participation balance and discussion productivity

2. **Individual confidence**: Measured through post-experiment survey about confidence in found defects

### Participants

**Sample size**:  11 participants (4 solo in Code 1, 4 solo in Code 2, 2 pairs in Code 1, 3 pairs in Code 2)

**Target population**: 5th-year Computer Science students at Poznan University of Technology

**Recruitment**:  Participants were recruited from PUT University, Software Engineering Course

**Inclusion criteria**: Students enrolled in 5th year of Computer Science program with at least basic Java programming knowledge

**Exclusion criteria**:  None applied

### Objects

Two Java code samples were used as objects for review:

**Code 1: tree_and_binary_search. java**
- Language: Java
- Approximate size: ~200-500 lines of code
- Domain: Data structures (Binary Search Tree)
- Complexity: Medium (recursive algorithms, tree traversal)
- Number of true defects: 14

**Code 2: graph_algorithms.java**
- Language: Java
- Approximate size: ~200-500 lines of code
- Domain: Graph algorithms
- Complexity: Medium (graph traversal, shortest path algorithms)
- Number of true defects: 29

Both code samples contained realistic defects commonly found in real-world code reviews, including null pointer exceptions, security vulnerabilities, logic errors, memory leaks, and style violations.

### Test Definition

**Design type**: Within-subjects repeated measures with counterbalancing

**Assignment strategy**: Participants were assigned to two groups with counterbalanced order of conditions:  

**Group 1**:
- Session 1: Code 1 (tree_and_binary_search.java) - SOLO:  Kasia P., Tomek, Ola, Erasmus
- Session 2: Code 2 (graph_algorithms. java) - PAIRS: Ola + Dominika, Kasia P. + Tomek, Michal + Erasmus

**Group 2**:  
- Session 1: Code 1 (tree_and_binary_search.java) - PAIRS: Dominik + Kasia R., Mateusz + Piotr
- Session 2: Code 2 (graph_algorithms.java) - SOLO: Kasia R., Dominik, Piotr, Mateusz

This design ensures that each participant experiences both conditions (solo and pair), which increases statistical power and controls for individual differences.  The counterbalancing controls for order effects and learning effects.  

**Pairing strategy**: For pair sessions, participants were paired according to their preferences. 

---

## Experiment Operation

### Prepared Instrumentation

The following materials and instruments were prepared for the experiment:

**1. GitHub Repository Structure:**

A dedicated GitHub repository was created with the following structure:  
```
code-review-experiment/
├── README.md (instructions)
├── Form ENG.csv
├── graph_algorithms.java (code 2)
└── tree_and_binary_search.java (code 1)
```

**2. Technical Environment:**

- **Platform**: GitHub Codespaces with pre-configured Java development environment
- **IDE**: Visual Studio Code with Java extensions
- **Java version**: JDK 17

**3. Participant Instructions (README.md):**

Comprehensive instructions provided to participants including:
- Task description:  Review Java code to find defects
- Reporting protocol: Raise hand and verbally report defects immediately when found
- Information to report: Line number, brief description of the defect, severity, and type
- Defect categories reference guide
- Time limits: 30 minutes per session
- Working mode guidelines (solo vs. pair)

**4. Defect Categories Reference (defect-categories.md):**

Participants were provided with clear definitions of:  

**Defect types:**
- Security:  Authentication, authorization, injection vulnerabilities, sensitive data exposure
- Performance: Memory leaks, inefficient algorithms, unnecessary operations
- Logic:  Incorrect behavior, edge cases, wrong algorithms
- Style: Naming conventions, formatting, code conventions

**5. Data Collection Form:**

A structured form was prepared to record:  
- Timestamp (elapsed time from session start)
- Session number (1 or 2)
- Participant ID
- Work mode (Solo/Pair)
- Code reviewed (1 or 2)
- Line number of defect
- Defect description
- Reported severity
- Reported type
- Validity assessment (Y/N/?)

**6. Answer Key:**

A comprehensive answer key was prepared listing defects in each code sample with:  
- Exact line numbers
- Justification for each classification

### Execution

**Date and time**: 27.11.2025

**Location**: Poznań

**Duration**:  Approximately 60 minutes total

**Procedure:**

The experiment followed this timeline:

**Phase 1: Introduction (10 minutes)**
- Welcomed participants and explained the overall goal
- Briefed participants on their tasks without revealing specific hypotheses
- Explained the reporting protocol
- Assigned participants to Group 1 or Group 2
- Distributed written instructions

**Phase 2: Technical Setup (5 minutes)**
- Participants logged into GitHub Codespaces
- Verified access to assigned code files
- Conducted a test defect report to ensure understanding of the protocol
- Answered any technical questions

**Phase 3: Session 1 (30 minutes)**
- Group 1: Reviewed Code 1 in SOLO mode
- Group 2: Reviewed Code 1 in PAIR mode
- Experimenter recorded all defect reports in real-time with timestamps
- Participants were instructed to report defects immediately upon discovery

**Phase 4: Break and Transition (5 minutes)**
- Short break for participants
- Pair assignments for Session 2 were announced
- Participants accessed the second code sample

**Phase 5: Session 2 (30 minutes)**
- Group 1: Reviewed Code 2 in PAIR mode
- Group 2: Reviewed Code 2 in SOLO mode
- Continued real-time data collection
- Maintained consistent reporting protocol

**Phase 6: Post-Experiment Survey (5 minutes)**
- Participants completed the Google Forms survey
- Survey link was provided in the repository README
- Participants completed survey individually

**Phase 7: Wrap-up (5 minutes)**
- Brief discussion about the experiment
- Opportunity for participants to ask questions
- Thanks and dismissal

**Data Collection Process:**

During each session, the experimenter: 
1. Documented participant/pair ID
2. Recorded each reported defect with line number
3. Did not provide feedback on defect validity during the session

**Post-Experiment Data Processing:**

After the experiment:  
1. Each reported defect was validated against the answer key
2. Defects were classified as True Positive (valid) or False Positive (invalid)
3. Survey responses were collected and linked to participant data
4. All data was entered into a structured spreadsheet for analysis

---

## Analysis and Interpretation

### Descriptive Statistics

**Data Completeness:**

- Total participants: 11 participants
- Complete data sets (both sessions): 11 participants (all completed both sessions)
- Excluded participants: None
- Survey response rate: 100%

**Validated Results by Participant/Pair:**

**Code 1 (tree_and_binary_search.java) - Solo reviewers:**

**Kasia P. :**
- Line 196: TP (path corruption issue)
- **TP = 1, FP = 0, Total = 1**
- **FP Rate = 0/(1+0) = 0.00 (0%)**

**Tomek:**
- TPs: 6, 24, 42, 60, 72, 105 (reported twice but counted once), 136, 159 = **8 unique TPs**
- FPs: 464, 480, 481, 7, 12, 74, 78, 87, 108, 111, 143, 151, 187 = **13 FPs**
- Total reported = 20
- **TP = 8, FP = 12, Total = 20**
- **FP Rate = 12/(8+12) = 12/20 = 0.60 (60%)**

**Ola:**
- Line 464: FP (out of bounds)
- Line 357: FP (out of bounds)
- **TP = 0, FP = 2, Total = 2**
- **FP Rate = 2/(0+2) = 1.00 (100%)**

**Erasmus:**
- Line 464: FP (out of bounds)
- Line 145: TP (no null check)
- **TP = 1, FP = 1, Total = 2**
- **FP Rate = 1/(1+1) = 0.50 (50%)**

**Code 1 (tree_and_binary_search.java) - Pair reviewers:**

**Dominik + Kasia R. :**
- Line 195: TP (path corruption)
- Line 291: TP (should use < and >)
- **TP = 2, FP = 0, Total = 2**
- **FP Rate = 0/(2+0) = 0.00 (0%)**

**Mateusz + Piotr:**
- Line 358: FP (out of bounds)
- Line 291: TP (should use < and >)
- **TP = 1, FP = 1, Total = 2**
- **FP Rate = 1/(1+1) = 0.50 (50%)**

**Code 2 (graph_algorithms. java) - Solo reviewers:**

**Kasia R.:**
- Line 19: TP (no check if list exists)
- Line 153: TP (doesn't work with cycles)
- Line 419: FP (out of bounds)
- **TP = 2, FP = 1, Total = 3**
- **FP Rate = 1/(2+1) = 0.33 (33%)**

**Dominik:**
- Line 19: TP
- Lines 47-51: TP (pre-allocating all vertices)
- Lines 77-96: TP (doesn't handle unreachable vertices)
- **TP = 3, FP = 0, Total = 3**
- **FP Rate = 0/(3+0) = 0.00 (0%)**

**Piotr:**
- No defects reported
- **TP = 0, FP = 0**
- **FP Rate = undefined (0/0)**

**Mateusz:**
- Line 42: FP
- Line 87: FP (valid code)
- Line 119: FP (valid code)
- Line 389: TP (shared reference bug)
- Line 38: TP (marked visited too early)
- Line 2137: FP (joke line number)
- Line 39: FP (valid code)
- **TP = 2, FP = 5, Total = 7**
- **FP Rate = 5/(2+5) = 0.71 (71%)**

**Code 2 (graph_algorithms. java) - Pair reviewers:**

**Ola + Dominika:**
- Line 464: FP (out of bounds)
- Line 2137: FP (joke line number)
- **TP = 0, FP = 2, Total = 2**
- **FP Rate = 2/(0+2) = 1.00 (100%)**

**Kasia P. + Tomek:**
- TPs: 16, 19, 20, 25, 30, 34, 58, 76, 107, 135, 143, 147, 272, 288, 295, 333, 365 (reported twice, counted once), 447 = **18 unique TPs**
- FPs: 526 (×2), 528, 535, 536, 537, 538, 539, 544, 24, 17, 21, 26, 40, 41, 44, 50, 52, 68, 70, 74, 85, 87, 115, 121, 129, 187, 248, 291, 299, 304, 306, 395, 448 = **34 FPs**
- **TP = 18, FP = 34, Total = 52**
- **FP Rate = 34/(18+34) = 34/52 = 0.65 (65%)**

**Michal + Erasmus:**
- Line 524: FP (out of bounds)
- Line 127: TP (defensive check issue)
- **TP = 1, FP = 1, Total = 2**
- **FP Rate = 1/(1+1) = 0.50 (50%)**

### Paired Dataset Creation

**Matching each participant's solo and pair scores:**

| Participant | Solo Session (Code) | Solo TP | Pair Session (Code) | Pair TP | Difference (Pair - Solo) |
|-------------|---------------------|---------|---------------------|---------|--------------------------|
| Kasia P.  | Code 1 | 1 | Code 2 (with Tomek) | 18 | +17 |
| Tomek | Code 1 | 8 | Code 2 (with Kasia P.) | 18 | +10  |
| Ola | Code 1 | 0 | Code 2 (with Dominika) | 0 | 0  |
| Erasmus | Code 1 | 1 | Code 2 (with Michal) | 1 | 0 |
| Dominik | Code 2 | 3 | Code 1 (with Kasia R.) | 2 | -1 |
| Kasia R. | Code 2 | 2 | Code 1 (with Dominik) | 2 | 0 |
| Mateusz | Code 2 | 2 | Code 1 (with Piotr) | 1 | -1 |
| Piotr | Code 2 | 0 | Code 1 (with Mateusz) | 1 | +1 |

**Note:** Pair TPs are shared between both members of each pair. 

### Summary Statistics

**Defect Detection Results:**

**Solo Performance (n=8):**
- TPs: 1, 8, 0, 1, 3, 2, 2, 0
- **Mean Solo TP = 2.13 ± 2.59**
- **Range: 0-8**

**Pair Performance (n=8):**
- Pair TPs: 18, 18, 0, 1, 2, 2, 1, 1
- **Mean Pair TP = 5.38 ± 7.82**
- **Range: 0-18**

**Difference Scores (Pair - Solo):**
- Differences: +17, +10, 0, 0, -1, 0, -1, +1
- **Mean Difference = 3.25 ± 6.63**
- **Range: -1 to +17**

| Metric | Solo | Pair |
|--------|------|------|
| **Mean True Positive Defects** | 2.13 ± 2.59 | 5.38 ± 7.82 |
| **Range** | 0-8 | 0-18 |

**False Positive Rate:**

| Participant | Solo FP Rate | Pair FP Rate |
|-------------|--------------|--------------|
| Kasia P. | 0.00 | 0.65 (shared with Tomek) |
| Tomek | 0.60 | 0.65 (shared) |
| Ola | 1.00 | 1.00 |
| Erasmus | 0.50 | 0.50 |
| Dominik | 0.00 | 0.00 |
| Kasia R. | 0.33 | 0.00 |
| Mateusz | 0.71 | 0.50 |
| Piotr | N/A (0/0) | 0.50 |

**Summary:**
- **Mean Solo FP Rate** (excluding Piotr's undefined): (0.00 + 0.60 + 1.00 + 0.50 + 0.00 + 0.33 + 0.71)/7 = 3.14/7 = **0.45 ± 0.38 (45%)**
- **Mean Pair FP Rate**: (0.65 + 0.65 + 1.00 + 0.50 + 0.00 + 0.00 + 0.50 + 0.50)/8 = 3.80/8 = **0.48 ± 0.32 (48%)**

### Hypotheses Testing

**Normality Testing:**

**Shapiro-Wilk Test on Difference Scores [17, 10, 0, 0, -1, 0, -1, 1]:**

The Shapiro-Wilk test was conducted to assess the normality of the difference scores (Pair - Solo):

- **W = 0.6880, p = 0.0016**

**Interpretation:** The difference scores significantly deviate from normality (W = 0.6880, p = 0.0016). This violation was expected given the extreme outliers (+17, +10) and clustering of zeros (4 out of 8 participants showed no change). Therefore, **the Wilcoxon signed-rank test is used as the primary analysis**, with the t-test reported as supplementary.

---

**H1: Defect Detection Effectiveness**

*Null Hypothesis (H1₀)*: μ_pair = μ_solo

*Alternative Hypothesis (H1₁)*: μ_pair > μ_solo (one-tailed)

**Parametric Analysis (Paired t-test):**

Given:  
- Mean difference = 3.25
- SD of differences = 6.63
- n = 8
- df = 7

Results:
- **SE of difference = SD / √n = 6.63 / √8 = 2.344**
- **t-statistic = Mean difference / SE = 3.25 / 2.344 = 1.387**
- **df = 7**
- **p-value (one-tailed) = 0.104**

**Decision:** At α = 0.05, **fail to reject H1₀** (p = 0.104 > 0.05)

**Effect Size (Cohen's d):**
- **Cohen's d = Mean difference / SD of differences**
- **d = 3.25 / 6.63 = 0.49**
- **Interpretation:  Medium effect size** (d = 0.5 is considered medium by Cohen's conventions:  small = 0.2, medium = 0.5, large = 0.8)

**Non-Parametric Analysis (Wilcoxon Signed-Rank Test) - PRIMARY ANALYSIS:**

Given the violation of normality assumptions, the Wilcoxon signed-rank test serves as the primary statistical test.

Difference scores: +17, +10, 0, 0, -1, 0, -1, +1

Procedure:
1. Remove zeros: +17, +10, -1, -1, +1 (n=5)
2. Rank absolute values: |17|=5, |10|=4, |-1|=2, |-1|=2, |1|=2 (average rank for ties = 2)
3. Assign signs: +5, +4, -2, -2, +2
4. Sum positive ranks: W+ = 5 + 4 + 2 = 11
5. Sum negative ranks: W- = 2 + 2 = 4
6. Test statistic: V = 11 (sum of positive ranks in R's implementation)

**Results:**
- **V = 11, p = 0.205 (one-tailed)**
- **Effect size r = 0.291** (small to medium effect; r: 0.1=small, 0.3=medium, 0.5=large)

**Decision:** At α = 0.05, **fail to reject H1₀** (p = 0.205 > 0.05)

**Interpretation:** The Wilcoxon signed-rank test confirms the t-test finding: pairs did not find significantly more defects than solo reviewers (V = 11, p = 0.205). However, the effect size (r = 0.291) suggests a small to medium practical effect. The small effective sample size (n = 5 after removing zeros) severely limits statistical power to detect effects.

---

**Power Analysis:**

**Note:** Power analysis using the `pwr` package could not be completed in the current computational environment. Based on standard power analysis tables for paired t-tests with the observed parameters:

**Observed effect size:** Cohen's d = 0.49 (medium effect)

**Estimated achieved power:**
- Test: Paired t-test (one-tailed)
- Effect size d = 0.49
- α = 0.05
- Sample size n = 8
- **Estimated power ≈ 0.35-0.40 (35-40%)**

**Estimated required sample size for 80% power:**
- To detect an effect of d = 0.49 with 80% power
- **Estimated required n ≈ 27-30 participants**

**Estimated minimum detectable effect at 80% power:**
- With current sample size n = 8
- **Estimated minimum detectable d ≈ 1.0-1.2 (large effect)**

**Interpretation:** With n=8, this study had approximately 35-40% power to detect the observed medium effect (d=0.49). To achieve 80% power, either:
- Sample size would need to be approximately 27-30 participants, OR
- True effect would need to be large (d > 1.0)

This low power substantially increases the risk of Type II error (failing to detect a real effect). The non-significant results should be interpreted with caution, as they may reflect insufficient power rather than true absence of effect.

---

**False Positive Rate Comparison:**

**Paired FP Rate Differences (Pair - Solo):**

| Participant | Solo FP | Pair FP | Difference |
|-------------|---------|---------|------------|
| Kasia P.  | 0.00 | 0.65 | +0.65 |
| Tomek | 0.60 | 0.65 | +0.05 |
| Ola | 1.00 | 1.00 | 0.00 |
| Erasmus | 0.50 | 0.50 | 0.00 |
| Dominik | 0.00 | 0.00 | 0.00 |
| Kasia R. | 0.33 | 0.00 | -0.33 |
| Mateusz | 0.71 | 0.50 | -0.21 |
| Piotr | 0.00* | 0.50 | +0.50 |

*Piotr's solo FP rate treated as 0.00 (0 reports)

**Statistics:**
- Mean Solo FP Rate = 0.39 (including Piotr as 0.00)
- Mean Pair FP Rate = 0.48
- Mean Difference = +0.08 (pairs had slightly higher FP rate)
- SD of Differences = 0.35

**Paired t-test on FP rates:**
- **t = 0.702, df = 7**
- **p-value = 0.505 (two-tailed)**

**Conclusion:** No significant difference in false positive rates between solo (39%) and pair (48%) conditions (t = 0.702, p = 0.505).

### Interpretation of Results

**Main Findings:**

**RQ1: Do pairs find more defects?**

Based on the statistical analysis:
- **Solo reviewers** detected an average of **2.13 ± 2.59** valid defects (range: 0-8)
- **Pair reviewers** detected an average of **5.38 ± 7.82** valid defects (range:  0-18)
- **Mean difference:** Pairs found 3.25 more defects on average
- **Primary statistical test:** Wilcoxon signed-rank test:  V = 11, p = 0.205 (one-tailed)
- **Supplementary test:** Paired t-test:  t(7) = 1.387, p = 0.104 (one-tailed)
- **Effect sizes:** Cohen's d = 0.49 (medium); r = 0.291 (small to medium)
- **Decision:** **Failed to reject the null hypothesis** at α = 0.05

**Interpretation:** While pairs detected 153% more defects on average (5.38 vs. 2.13), this difference was **not statistically significant** (Wilcoxon: p = 0.205; t-test: p = 0.104). However, the **medium effect size (d = 0.49)** suggests a meaningful practical difference that may have been obscured by: 
1. **Small sample size** (n=8 provides only ~35-40% estimated power to detect this effect)
2. **High variability** in both conditions (SD of 2.59 for solo, 7.82 for pair)
3. **Extreme individual differences** in performance
4. **Non-normal distribution** with extreme outliers (+17, +10) and clustered zeros

**Power analysis** revealed that detecting the observed effect (d=0.49) with 80% power would require approximately **27-30 participants** rather than 8. Conversely, with n=8, only **very large effects (d > 1.0)** could be reliably detected.

**Practical significance:** Despite statistical non-significance, the finding that pairs detected 3.25 more defects on average may have **practical value** for code review practices, warranting further investigation with larger samples. The substantial effect size combined with the directionally consistent (though non-significant) results from both parametric and non-parametric tests suggests this finding deserves attention.

**RQ2: Is solo review faster?**

**Time data was not collected in this experiment.** This research question cannot be answered. 

**Secondary Findings:**

**1. False Positive Rates:**

- **Solo FP rate:** 45% ± 38% (range: 0%-100%)
- **Pair FP rate:** 48% ± 32% (range: 0%-100%)
- **Difference:** Not statistically significant (t = 0.702, p = 0.505)

**Interpretation:** Both solo and pair reviewers had similarly high false positive rates (~45-48%), meaning nearly half of all reported "defects" were invalid.  This suggests: 
- **Task ambiguity:** Participants may have had unclear understanding of what constitutes a defect
- **Over-reporting:** Time pressure or performance anxiety may have led to reporting marginal issues

Notable variation exists between participants, with some achieving 0% FP rates while others reached 100%, indicating substantial differences in understanding or strategy.

**2. Individual Variability:**

The data shows **extremely high variability**:
- **Solo performance:** Coefficient of variation = SD/Mean = 2.59/2.13 = 1.22 (122%)
- **Pair performance:** Coefficient of variation = 7.82/5.38 = 1.45 (145%)

This variability exceeded the mean itself, indicating:
- **Individual/pair differences dominate:** Who performs the review matters considerably
- **Skill heterogeneity:** Participants ranged from finding 0 defects to finding 8 (solo) or 18 (pair)
- **Pair dynamics critical:** Different pairs showed dramatically different performance levels

**Implications:**
- Selecting **skilled reviewers** may be important for effective code review
- **Pair composition** appears to matter substantially—not all pairs perform equally
- **Training and calibration** could reduce variability

**3. Code Difficulty Imbalance:**

Code 2 (graph_algorithms.java) had **29 true defects** compared to Code 1 (tree_and_binary_search.java) with **14 defects**—more than 2× difference. This imbalance may have affected results:
- Group 1: Solo on Code 1 (fewer defects), Pair on Code 2 (more defects)
- Group 2: Pair on Code 1 (fewer defects), Solo on Code 2 (more defects)

While counterbalancing distributes this effect across both conditions, the large difficulty gap represents a confounding factor that should be addressed in future studies.

**4. Data Quality Concerns:**

Several anomalies were identified:
- **Out-of-bounds line numbers:** 464, 480, 524, 526, 528 (files had <500 lines)
- **Joke line number:** 2137 reported by multiple participants
- **Range notations:** "47-51", "77-96" (unclear if single defect or multiple)
- **Duplicate reports:** Some line numbers reported twice by the same participant/pair

**Recommendations:**
- Stricter reporting protocol with real-time validation
- Clearer instructions distinguishing single vs. multi-line defects
- Better answer key with accepted line ranges

---

## Threats to Validity

This section discusses potential threats to the validity of our findings and the measures taken to mitigate them.

### Conclusion Validity

Conclusion validity concerns whether we can correctly infer a relationship between treatment and outcome. 

**Threat 1: Small Sample Size**

- *Description*: With 11 participants (8 effective pairs for analysis), statistical power may be limited to detect small or medium effects. 
- *Mitigation*:  Within-subjects design was chosen to increase statistical power by controlling for individual differences.  Each participant served as their own control, effectively maximizing information from the available sample. 
- *Residual risk*: **HIGH**. Power analysis revealed: 
  - **Achieved power:** ~35-40% for the observed medium effect (d=0.49)
  - **Required sample size:** ~27-30 participants needed for 80% power
  - **Minimum detectable effect:** d > 1.0 (very large) for 80% power with n=8
- *Impact*: The non-significant result (Wilcoxon: p=0.205; t-test: p=0.104) may represent a **Type II error**—failing to detect a real effect due to insufficient power rather than true absence of effect.  The medium effect size (d=0.49) suggests pairs may genuinely find more defects, but the study lacked power to confirm this statistically.

**Threat 2:  Reliability of Measurements**

- *Description*:  Defect classification involves subjective judgment, which could introduce measurement error.
- *Mitigation*: A detailed answer key was prepared in advance with clear criteria for each defect. 
- *Residual risk*: **MEDIUM**. The high false positive rates (45-48%) and extreme variability suggest: 
  - Participants interpreted "defect" differently (evidenced by FP rates ranging 0%-100%)
  - Some participants reported aggressively (high report counts)
  - Others were conservative (low report counts)
  - Answer key validation revealed many invalid reports (out-of-bounds line numbers, joke entries)

**Threat 3: Violation of Statistical Test Assumptions**

- *Description*: Parametric tests assume normality of distributions (specifically, difference scores in paired tests).
- *Mitigation*: Shapiro-Wilk test was conducted (W = 0.6880, p = 0.0016), confirming violation of normality. Wilcoxon signed-rank test was used as the primary analysis.
- *Residual risk*: **MITIGATED**. The difference scores [17, 10, 0, 0, -1, 0, -1, 1] contain: 
  - **Extreme outliers** (+17, +10)
  - **Clustered zeros** (4 out of 8 participants showed no change)
  - This distribution is **non-normal**, violating t-test assumptions
- *Action taken*: **Wilcoxon signed-rank test was completed and reported as the primary analysis.** The t-test results are reported as supplementary, acknowledging the normality violation.

**Threat 4: Outliers and Data Quality**

- *Description*:  Extreme values and suspicious entries threaten the validity of conclusions.
- *Issues identified*:
  1. Large variation in reports per participant/pair (1-52 defects reported)
  2. **Out-of-bounds line numbers:** 464, 480, 481, 524, 526, 528, 535-539, 544 (files had <500 lines)
  3. **Joke entry:** Line 2137 reported by multiple participants
  4. **Range notations:** "47-51", "77-96" (ambiguous reporting)
  5. **Duplicate entries:** Lines 105, 526, 365 reported twice
- *Mitigation*: All line numbers were validated against the answer key.  Suspicious entries were classified as false positives.
- *Residual risk*: **MEDIUM to HIGH**. The wide variation in reporting behavior suggests different interpretations of the task or different reporting strategies. 

### Internal Validity

Internal validity concerns whether the observed effects can be attributed to the independent variable rather than confounding factors.

**Threat 1: Learning Effects**

- *Description*:  Participants might improve their code review skills between Session 1 and Session 2, potentially confounding treatment effects with learning effects.
- *Mitigation*: Counterbalancing was implemented: 
  - Group 1: Solo (Code 1) → Pair (Code 2)
  - Group 2: Pair (Code 1) → Solo (Code 2)
- *Residual risk*: **LOW**, assuming counterbalancing worked.  Learning effects should affect both conditions equally.  However, the 5-minute break may have been insufficient for mental reset. 

**Threat 2: Fatigue Effects**

- *Description*:  Participants might perform worse in Session 2 due to mental fatigue from Session 1.
- *Mitigation*: 
  - A 5-minute break was provided between sessions
  - Each session was limited to 30 minutes to prevent excessive fatigue
  - Counterbalancing ensures fatigue affects both conditions equally
- *Residual risk*: **MEDIUM**. Code review is mentally demanding.  30 minutes × 2 sessions = 60 minutes of intense focus may have induced fatigue.  Counterbalancing distributes this equally, but if fatigue is severe, it increases noise/variability. 

**Threat 3: Code Difficulty Imbalance**

- *Description*: Code 1 and Code 2 differ substantially in difficulty. 
- *Evidence*: 
  - **Code 1:** 14 true defects
  - **Code 2:** 29 true defects (207% of Code 1)
  - This is a **major imbalance** contrary to the claim they were "similar"
- *Mitigation*: Counterbalancing ensures each code was reviewed by both solo and pair conditions. 
- *Residual risk*: **HIGH**. The 2× defect count difference is a major confound.  Code 2 may have been genuinely harder (more defects to find) or just longer/more complex.  This could interact with work mode:  pairs may benefit more on harder code. 

**Threat 4: Hawthorne Effect**

- *Description*: Participants may alter their behavior because they know they are being observed and studied.
- *Mitigation*: Participants were told the study's general purpose without revealing specific hypotheses about pair superiority, reducing demand characteristics.
- *Residual risk*: **HIGH**. The high report counts from some participants suggest possible **over-reporting** to appear thorough.  The high FP rates (45-48%) support this:  participants may have reported marginal issues they wouldn't normally flag to maximize perceived performance. 
- *Impact*: This threatens **external validity**—real-world code reviewers wouldn't report every minor issue if not being evaluated.

**Threat 5: Pair Dynamics Variability**

- *Description*:  Different pairs may have vastly different collaboration dynamics (dominant vs. balanced), introducing noise in the pair condition.
- *Evidence*:  **Substantial variability** in pair performance with an 18× difference in valid defects found between most and least productive pairs.
- *Mitigation*: Post-experiment survey measured pair dynamics.  Pairs were formed by participant preference (which may have helped or hindered).
- *Residual risk*: **HIGH**. The pair condition is not a homogeneous treatment—it represents different pair experiences with varying collaboration dynamics. 

**Threat 6: Task Understanding Variability**

- *Description*:  Participants may have understood "what counts as a defect" differently. 
- *Evidence*: 
  - **Reporting intensity:** 0-52 defects reported (massive range)
  - **False positive rates:** 0%-100% (participants had completely different accuracy)
  - **Out-of-bounds line numbers:** Suggest some didn't understand the task
  - **Joke entries (2137):** Suggests some weren't taking it seriously or testing the system
- *Mitigation*: 
  - Defect categories guide was provided
  - Instructions clarified reporting protocol
  - Answer key defines ground truth
- *Residual risk*: **HIGH**. The data suggests different participants used different criteria: 
  - **Conservative interpreters:** Reported only obvious bugs (0-3 defects)
  - **Aggressive interpreters:** Reported many issues including minor ones (20+ defects)
  - **Style vs. logic:** Some may have focused on style issues; others on functional bugs
- *Impact*: This threatens the dependent variable's validity.  We may not be measuring the same construct consistently across participants. 

### Construct Validity

Construct validity concerns whether the measured variables truly represent the theoretical constructs of interest.

**Threat 1: Artificially Inserted Defects**

- *Description*: Deliberately inserted defects may not reflect the distribution and subtlety of real-world bugs.
- *Mitigation*: Defects were chosen to represent common, realistic issues found in actual code reviews (null pointer exceptions, security vulnerabilities, logic errors, memory leaks, style violations).
- *Residual risk*: **MODERATE**. Real code reviews involve: 
  - Unknown numbers of defects (reviewers don't know when they're "done")
  - Natural distribution of defect types (not artificially balanced)
  - Ambiguous cases where "is this a bug?" is subjective
  - Context from project history, requirements, previous discussions
- *Impact*: This study measures "defect detection given known embedded defects," which may not generalize to "defect detection in organically developed code with unknown defect count." Reviewers may change strategy if they don't know the expected number of defects.

**Threat 2: Defect Counting as Sole Metric**

- *Description*:  Counting defects assumes all defects are equally important, which is false. 
- *Evidence from design*:  Defects were assigned severities (Critical, Major, Minor), but analysis treats all TPs equally.
- *Impact*: Finding 1 critical security vulnerability is more valuable than finding 10 minor style issues, but both count as "1 defect." The current analysis doesn't differentiate defect importance.
- *Residual risk*: **MODERATE**. Current results may overvalue quantity over quality of defects found.

**Threat 3: Time Limit Effects**

- *Description*:  The 30-minute time limit may not reflect typical code review conditions and may introduce strategic trade-offs.
- *Impact*: 
  - Participants may prioritize **speed** (report many defects quickly) over **accuracy** (carefully validate each defect)
  - This could explain the high FP rates (45-48%)—participants reported marginal issues rather than taking time to verify
  - Pairs may face additional time pressure due to communication overhead
- *Mitigation*: Time limit was consistent across both conditions. 
- *Residual risk*: **MODERATE**. Real code reviews vary widely: 
  - **Formal inspections:** Unlimited time, thorough analysis
  - **PR reviews:** Asynchronous, done over days
  - **Rapid reviews:** Very short time, focus on critical issues only

The 30-minute limit may have artificially induced a "quantity over quality" strategy that wouldn't occur in real reviews. 

**Threat 4: Pair vs. Solo Construct Clarity**

- *Description*: "Pair code review" as implemented may not represent how pairs actually work in industry.
- *Implementation*: Driver-navigator pattern with one computer, synchronous collaboration, immediate verbal reporting
- *Real-world variation*: 
  - **Asynchronous pair review:** Two people review sequentially, discuss findings afterward
  - **Collaborative PR review:** Two reviewers comment on GitHub PR independently, then discuss
  - **Independent-then-merge:** Pairs work separately, then consolidate findings
  - **Round-robin:** Multiple pairs/individuals review the same code
- *Residual risk*: **MODERATE**. Results apply to **synchronous driver-navigator pair review**, which is one implementation but not the only or most common form of "pair code review."
- *Impact*:  Generalization to other collaborative review formats is limited.

### External Validity

External validity concerns the generalizability of findings to other contexts, populations, and settings.

**Threat 1: Student Sample**

- *Description*: 5th-year computer science students may differ from professional software developers in experience, motivation, domain knowledge, and code review skills.
- *Mitigation*: 
  - Participants were senior students with several years of programming experience
  - Results are explicitly framed as applicable to this population
- *Residual risk*: **VERY HIGH**.  Generalization to professional developers requires extreme caution: 
  - **Experience:** Professionals have 5-20+ years; students have 2-5 years
  - **Code review training:** Professionals often receive formal training; students likely do not
  - **Domain expertise:** Professionals specialize (security, performance, etc.); students are generalists
  - **Motivation:** Professionals' code goes to production with real consequences; students know it's an experiment
  - **Calibration:** Professionals have internalized "what matters"; students may not (evidenced by high FP rates)
- *Recommendation*: **Clearly state in conclusions:** "Results apply to senior computer science students performing experimental code reviews.  Replication with professional developers is essential before generalizing to industry practice."

**Threat 2: Laboratory Setting**

- *Description*:  The controlled laboratory environment differs fundamentally from real software development settings.
- *Differences*:
  - **Context:** Real reviews have project history, requirements docs, previous PR discussions, architectural decisions
  - **Ownership:** Real reviewers may have written some of the code or be maintaining it long-term
  - **Stakes:** Real reviews affect production code; experiment has no consequences
  - **Timing:** Real reviews are often asynchronous over days; experiment was synchronous 30-minute sessions
  - **Tools:** Real reviews use GitHub PR interface, CI/CD checks, linters; experiment used raw code files
  - **Team dynamics:** Real reviews involve established teams with known expertise; experiment used ad-hoc pairs
- *Mitigation*:  GitHub Codespaces provided a realistic development environment, and tasks were designed to simulate actual code review. 
- *Residual risk*: **VERY HIGH**. The laboratory setting removes most of the contextual factors that influence real code reviews.  Results may not generalize to: 
  - Asynchronous, distributed reviews
  - Reviews with full project context
  - Reviews where reviewers have domain expertise
  - Reviews with real production consequences

**Threat 3: Limited Code Samples**

- *Description*: Only two Java code samples were used; results may not generalize to other languages, paradigms, domains, or code characteristics.
- *Mitigation*:  Code samples represented different domains (data structures vs. graph algorithms) to increase variety.
- *Residual risk*: **VERY HIGH**.  Generalization is severely limited:
  - **Language:** Java vs. Python, JavaScript, C++, Rust, Go, etc.  (different idioms, conventions, error patterns)
  - **Paradigm:** Object-oriented vs. functional programming (FP reviewers look for different defects)
  - **Domain:** Academic algorithms vs. web development, system programming, data science, embedded systems, DevOps
  - **Code size:** ~200-500 LOC vs. real systems with 10K-1M+ LOC
  - **Code quality:** Artificially constructed with embedded defects vs. organically evolved code
  - **Legacy vs. new code:** These were standalone files, not part of a large codebase
- *Recommendation*: **State explicitly:** "Results apply to medium-length Java algorithm implementations in an academic context. Generalization to other languages, domains, and codebases requires replication studies."

**Threat 4: Task Specificity**

- *Description*:  Findings apply to defect detection in code review but may not generalize to other collaborative programming activities.
- *Comparison to related activities*:
  - **Pair programming (writing code together):** Real-time collaboration during creation; may benefit more from pair's "thinking aloud" and immediate error catching
  - **Architectural design:** Benefits from diverse perspectives, brainstorming; pairs likely superior
  - **Debugging:** Benefits from "rubber duck" effect of explaining to partner; pairs likely superior
  - **Code review (this study):** Systematic inspection of existing code; pairs may or may not help
  - **Testing:** Designing test cases; pairs may generate more diverse scenarios
- *Residual risk*: **MODERATE** for generalizing within code review domain; **HIGH** for generalizing to other collaborative programming activities.
- *Impact*: Cannot assume pair programming research findings apply to code review or vice versa—these are distinct tasks with different cognitive demands.

**Threat 5: Cultural and Educational Context**

- *Description*: The study was conducted at Poznan University of Technology with Polish computer science students.  Educational systems, programming training, collaboration norms, and cultural attitudes toward teamwork vary globally.
- *Examples of variation*:
  - **Collaboration culture:** Some cultures emphasize individual achievement; others emphasize collective work
  - **Education style:** Some universities teach pair programming extensively; others focus on individual coding
  - **Communication norms:** Directness, hierarchy, conflict resolution styles vary
  - **Programming language emphasis:** Some programs focus on Java; others on Python, C++, etc.
- *Residual risk*: **MODERATE**. Results may not generalize to students in other countries, educational systems, or with different programming curricula.
- *Recommendation*: Multi-site replication studies across different universities and countries would strengthen external validity.

### Summary of Validity Assessment

**Strengths of the experimental design:**
1. ✓ **Within-subjects design** with counterbalancing controls for individual differences and order effects
2. ✓ **Structured protocol** with clear instructions, defect categories, and answer key
3. ✓ **Realistic task** using actual Java code with embedded defects representative of real issues
4. ✓ **Controlled environment** (GitHub Codespaces, time limits, standardized reporting)
5. ✓ **Balanced treatment order** to control for learning and fatigue effects
6. ✓ **Appropriate statistical analysis** using non-parametric test given normality violation

**Critical limitations:**
1. ✗ **Very small sample** (n=8) → **Achieved only ~35-40% power** → High risk of Type II error
2. ✗ **Normality violation** confirmed (W=0.6880, p=0.0016) → **Addressed by using Wilcoxon test**
3. ✗ **Task understanding variability** → FP rates 0%-100%, reporting 0-52 defects
4. ✗ **Code difficulty imbalance** → Code 2 had 207% more defects than Code 1 → Confounds results
5. ✗ **Pair dynamics variability** → Large differences in pair performance
6. ✗ **Student sample** → Limits generalization to professional developers
7. ✗ **Laboratory setting** → Removes most real-world context from code reviews
8. ✗ **Limited code samples** → Only 2 Java files, specific domains → Generalization to other languages/domains questionable

**Most critical threats (priority order):**
1. **Insufficient statistical power:** Only 35-40% power to detect the observed effect.  **Results may be false negative (Type II error).**
2. **Task understanding inconsistency:** Participants used different criteria for "what is a defect," evidenced by 0%-100% FP rates. 
3. **Code difficulty imbalance:** 2× defect count difference between codes is a major confound.  **Future studies must control this.**
4. **High variability:** Individual/pair differences may dominate treatment effects. 

**Recommendation:** The normality violation has been addressed by completing the Wilcoxon signed-rank test as the primary analysis. However, the small sample size and high variability remain critical limitations that should be explicitly stated in the conclusions.

---

## Conclusions

This experiment investigated the effectiveness of pair code review compared to solo code review in terms of defect detection using a within-subjects repeated measures design with 8 participants (11 total, analyzed as 8 participant-pairs).

**Key Findings:**

**1. Defect Detection (H1):**
- **Solo reviewers:** Mean = **2.13 ± 2.59** defects (range:  0-8)
- **Pair reviewers:** Mean = **5.38 ± 7.82** defects (range: 0-18)
- **Difference:** Pairs found **3.25 more defects** on average (+153%)
- **Primary statistical test:** Wilcoxon signed-rank test: V = 11, **p = 0.205** (one-tailed)
- **Supplementary test:** Paired t-test: t(7) = 1.387, **p = 0.104** (one-tailed)
- **Effect sizes:** Cohen's d = **0.49** (medium); r = **0.29** (small to medium)
- **Power:** Estimated achieved power ≈ 35-40% (study was severely underpowered)
- **Decision:** **Failed to reject null hypothesis** at α = 0.05

**Interpretation:** While pairs detected substantially more defects on average (153% increase), this difference was **not statistically significant** (Wilcoxon: p = 0.205; t-test: p = 0.104). However, the **medium effect size (d = 0.49)** suggests a meaningful practical difference that warrants attention.  The non-significant result is likely due to: 
- **Insufficient statistical power:** Only ~35-40% power to detect the observed effect; 27-30 participants would be needed for 80% power
- **High variability:** Solo SD=2.59 (122% of mean), Pair SD=7.82 (145% of mean)
- **Individual differences:** Substantial variation in performance across participants
- **Non-normal distribution:** Confirmed by Shapiro-Wilk test (W=0.6880, p=0.0016) with extreme outliers and clustered zeros

**Practical significance:** The finding that pairs detect 3.25 additional defects (from 2.13 to 5.38) may have **practical value** for software teams, even without statistical significance. A 153% improvement in defect detection could justify the cost of pair reviews in high-stakes contexts (e.g., security-critical code). However, this must be balanced against the **high variability**—not all pairs performed equally well. 

**2. False Positive Rates:**
- **Solo:** 45% ± 38% (range: 0%-100%)
- **Pair:** 48% ± 32% (range: 0%-100%)
- **Statistical test:** Paired t-test:  t(7) = 0.702, p = 0.505
- **Conclusion:** No significant difference between solo and pair false positive rates

**Interpretation:** Both solo and pair reviewers had **high false positive rates** (~45-48%), meaning nearly half of all reported "defects" were invalid. This suggests:
- **Unclear task definition:** Participants may not have fully understood what constitutes a valid defect
- **Over-reporting strategy:** Time pressure or performance anxiety may have led to "report everything that looks suspicious" behavior

The wide range in FP rates (0%-100%) indicates substantial differences in participant understanding or approach to the task. 

**3. Extreme Variability:**

The most striking finding is the **extreme heterogeneity** in performance:
- **Solo:** 0-8 defects (coefficient of variation = 122%)
- **Pair:** 0-18 defects (coefficient of variation = 145%)
- **18× difference** between most and least productive pairs

**Implications:**
- **Individual/pair differences may dominate treatment effects:** Who performs the review matters considerably
- **Pair composition is critical:** Not all pairs are equal; collaboration dynamics significantly affect outcomes
- **Skill and motivation vary widely:** Participants showed very different levels of engagement and capability

**Practical recommendations:**
1. **Select skilled reviewers:** Individual capability appears to matter substantially
2. **Form pairs carefully:** Pair composition and dynamics significantly influence effectiveness
3. **Provide training:** Calibration on what constitutes a defect would reduce variability and FP rates
4. **Consider context:** Pair review may be more valuable for complex or critical code where finding more defects justifies the additional effort

**4. Limitations:**

**Statistical limitations:**
- **Small sample size (n=8):** Insufficient power to detect medium effects with statistical significance
- **Type II error risk:** Non-significant result may reflect inadequate power rather than true null effect
- **High variability:** Individual differences create substantial noise, requiring larger samples to detect treatment effects
- **Non-normal distribution:** Addressed by using Wilcoxon signed-rank test as primary analysis

**Design limitations:**
- **Code difficulty imbalance:** Code 2 had 2× more defects than Code 1, potentially confounding results
- **Data quality issues:** Out-of-bounds line numbers, duplicate entries, and joke inputs suggest some task misunderstanding
- **Task understanding variability:** Wide range in FP rates (0%-100%) indicates inconsistent interpretation of "defect"

**Generalizability limitations:**
- **Student sample:** Results may not generalize to professional developers with more experience and training
- **Laboratory setting:** Controlled environment lacks the context, stakes, and workflow of real code reviews
- **Limited code samples:** Only 2 Java files in academic algorithm domains; unclear if results apply to other languages, domains, or code types
- **Specific collaboration mode:** Results apply to synchronous driver-navigator pairing, which is one of many collaborative review approaches


**6. Final Conclusions:**

This exploratory study provides **preliminary evidence** that pair code review may improve defect detection compared to solo review, with pairs finding an average of 3.25 more defects (153% increase, Cohen's d=0.49, r=0.29). However, this difference did not reach statistical significance (Wilcoxon: p=0.205; t-test: p=0.104), likely due to insufficient statistical power (n=8, achieved power ~35-40%).

The **high variability** in performance suggests that individual reviewer capability and pair dynamics may be as important—or more important—than the choice between solo and pair review. Organizations should focus on:
- Selecting skilled reviewers
- Forming effective pairs with compatible collaboration styles
- Providing training on defect identification and classification
- Applying pair review selectively to high-value or complex code

**Critical caveat:** Results are based on senior computer science students reviewing academic Java code in a controlled laboratory setting. Generalization to professional software development requires replication with industry practitioners, diverse code samples, and realistic review workflows.

**Final recommendation:** Given the medium effect size and practical significance, pair code review warrants further investigation with adequately powered studies. Organizations interested in adopting pair review should conduct pilot studies within their specific context to assess effectiveness given their team composition, code characteristics, and development workflows. The substantial directional trend observed in this study, while not reaching statistical significance, suggests that the question of pair code review effectiveness remains open and deserving of additional research with larger, more diverse samples.

---

**End of Report**

---
