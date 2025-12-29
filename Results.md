# Report from Controlled Experiment:  Code Review Solo vs.  Pairs

**Authors:**

Szymon Haj, 153059

Marcin Stecewicz

Poznan, 22. 12.2025

---

## Introduction

This report presents the design and summarizes results of the experiment **"Code Review Solo vs. Pairs:  A Comparative Study of Defect Detection Effectiveness"**. The experiment was part of a project realized within the Quality Management and Experimental Software Engineering classes at Poznan University of Technology.

The motivation for this study stems from the ongoing debate in software engineering about the effectiveness of pair programming and collaborative code review practices. While pair programming has been studied extensively, the specific context of code review—where developers systematically examine code to find 
defects—presents unique characteristics that warrant separate investigation.  Understanding whether working in pairs improves defect detection during code review has practical implications for software development teams seeking to optimize their quality assurance processes.

---

## Experiment Definition

The goal of the experiment was to: 

- **Object of study**: Code review process performed by students
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
- H1₁: Pairs find significantly more defects than individuals working solo (μ_pair > μ_solo)

**H2 (Time Efficiency):**
- H2₀: There is no significant difference in time to detect defects between solo and pair code review (μ_time_solo = μ_time_pair)
- H2₁: Solo code review is significantly faster in defect detection (μ_time_solo < μ_time_pair)

### Variables and Confounding Factors

**Independent Variable:**
- **Work mode**:  Categorical variable with two levels
  - Solo: Individual code review
  - Pair: Two-person collaborative code review

**Dependent Variables:**

1. **Number of defects found**:  Continuous variable (0-10 scale)
   - Measurement: Count of valid defects reported by participant/pair
   
2. **False positive rate**: Continuous variable (0-1 scale)
   - Calculation: FP / (True Positives + FP)

**Controlled Confounding Factors:**

1. **Programming experience**: Controlled through demographic survey; all participants are 5th-year Computer Science students with similar educational background

2. **Learning effect**: Controlled through counterbalancing design—half of participants start with solo review, half start with pair review

3. **Code difficulty**: Controlled by using two code samples (Code A:  Binary Search Tree, Code B: User Authentication System) with similar characteristics: 
   - Both contain exactly 10 deliberately inserted defects
   - Similar lines of code (~150 LOC each)
   - Similar distribution of defect severity
   - Both represent realistic programming scenarios

4. **Order effects**: Mitigated through counterbalancing—Group 1 reviews Code A then Code B, Group 2 reviews Code B then Code A

5. **Fatigue**:  Controlled through 5-minute break between sessions and limiting each session to 30 minutes

**Uncontrolled/Measured Confounding Factors:**

1. **Pair dynamics**: Measured through post-experiment survey questions about participation balance and discussion productivity

2. **Individual confidence**: Measured through post-experiment survey about confidence in found defects

### Participants

**Sample size**:  11 participants (4 solo in Code 1, 3 solo in Code 2, 2 pairs in Code 1, 3 pairs in Code 2)

**Target population**: 5th-year Computer Science students at Poznan University of Technology

**Recruitment**:  Participants were recruited from PUT University, Software Engineering Course

**Inclusion criteria**: Students enrolled in 5th year of Computer Science program with at least basic Java programming knowledge

**Exclusion criteria**:  None applied

### Objects

Two Java code samples were used as objects for review:

**Code A (Code 1): Binary Search Tree Implementation**
- Language: Java
- Approximate size: ~500 lines of code
- Domain: Data structures
- Complexity: Medium (recursive algorithms, tree traversal)

**Code B (Code 2): User Authentication System**
- Language: Java
- Approximate size: ~500 lines of code
- Domain:  Security/authentication
- Complexity: Medium (cryptography, data structures)

Both code samples contained realistic defects commonly found in real-world code reviews, including null pointer exceptions, security vulnerabilities, logic errors, memory leaks, and style violations.

### Test Definition

**Design type**: Within-subjects repeated measures with counterbalancing

**Assignment strategy**: Participants were assigned to two groups with counterbalanced order of conditions: 

**Group 1**:
- Session 1: Code 1 - SOLO (individual work): Kasia P., Tomek, Ola, Erasmus
- Session 2: Code 2 - PAIRS (paired in groups of 2): Ola + Dominika, Kasia P. + Tomek, Michal + Erasmus

**Group 2**: 
- Session 1: Code 1 - PAIRS (paired in groups of 2): Dominik + Kasia R., Mateusz + Piotr
- Session 2: Code 2 - SOLO (individual work): Kasia R., Dominik, Piotr, Mateusz

This design ensures that each participant experiences both conditions (solo and pair), which increases statistical power and controls for individual differences.  The counterbalancing controls for order effects and learning effects. 

**Pairing strategy**: For pair sessions, participants were paired according to their preferences.  Each pair worked at a single computer, following the driver-navigator pattern where both members actively participated in defect identification.

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
├── graph_algorithms.java (code 1)
├── tree_and_binary_search.java (code 2)
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
- Code reviewed (A or B)
- Line number of defect
- Defect description
- Reported severity
- Reported type
- Validity assessment (Y/N/?)

**7. Answer Key:**

A comprehensive answer key was prepared listing defects in each code sample with: 
- Exact line numbers
- Justification for each classification

### Execution

**Date and time**: 27. 11.2025

**Location**:  Poznań

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
2. Did not provide feedback on defect validity during the session

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
- Survey response rate:  Awaiting survey data

**Raw Data Summary from Tables:**

**Code 1 (Solo reviewers):**
- Kasia P.:  1 defect reported (line 196)
- Tomek: 20 defects reported (lines 464, 480, 481, 6, 7, 12, 24, 42, 60, 72, 74, 78, 87, 105, 108, 111, 105 duplicate, 136, 143, 151, 159, 187)
- Ola: 2 defects reported (lines 464, 357)
- Erasmus: 2 defects reported (lines 464, 145)

**Code 1 (Pair reviewers):**
- Dominik + Kasia R.: 2 defects reported (line)
- Mateusz + Piotr: 1 defect reported (lines 358, 291)

**Code 2 (Solo reviewers):**
- Kasia R.: 3 defects reported (lines 19, 153, 419)
- Dominik: 2 defects reported (lines 19, 47-51, 77-96)
- Piotr: 0 defects reported
- Mateusz: 5 defects reported (lines 42, 87, 119, 389, 38, 2137, 39)

**Code 2 (Pair reviewers):**
- Ola + Dominika: 2 defects reported (lines 464, 2137)
- Kasia P. + Tomek: 52 defects reported (lines 526, 526 duplicate, 528, 535, 536, 537, 538, 539, 544, 16, 24, 17, 19, 20, 21, 25, 26, 30, 34, 40, 41, 44, 50, 52, 58, 68, 70, 76, 74, 85, 87, 107, 115, 121, 129, 135, 143, 147, 187, 248, 272, 288, 291, 295, 299, 304, 306, 333, 365, 365 duplicate, 395, 447, 448)
- Michal + Erasmus: 2 defects reported (lines 524, 127)

**IMPORTANT NOTE:** To complete the analysis below, you must: 
1. **Validate each line number against the answer key** to determine which are true positives (valid defects) versus false positives
2. **Calculate mean ± standard deviation** for each metric
3. **Perform statistical tests** (normality checks, t-tests or Wilcoxon tests)

**Preliminary Summary (requires validation against answer key):**

**Code 1:**
- Solo reviewers (n=4): Range 1-20 reported defects
- Pair reviewers (n=2): Range 1-2 reported defects

**Code 2:**
- Solo reviewers (n=4): Range 0-5 reported defects
- Pair reviewers (n=3): Range 2-52 reported defects

**Next Steps for Complete Analysis:**

1. **You must count the actual valid defects** by comparing reported line numbers to the answer key
2. **Calculate false positive rate** for each participant/pair:  FP / (TP + FP)
3. **Calculate descriptive statistics**:  mean, SD, min, max for solo vs. pair conditions
4. **Perform normality tests** (Shapiro-Wilk) on the distributions
5. **Conduct hypothesis tests** (paired t-test or Wilcoxon signed-rank test)
6. **Calculate effect sizes** (Cohen's d)

**Recommended Statistical Software:**
- Use R, Python (scipy. stats), SPSS, or Excel for calculations
- For paired samples, ensure each participant's solo score is paired with their pair score

**Defect Detection Results:**

*Note: The following table requires you to validate reported defects against the answer key and calculate true positives*

| Metric | Solo (Mean ± SD) | Pair (Mean ± SD) | Min-Max Solo | Min-Max Pair |
|--------|------------------|------------------|--------------|--------------|
| Total defects reported | Calculate from validated data | Calculate from validated data | 0-20 | 1-52 |
| True positive defects | **Requires answer key validation** | **Requires answer key validation** | **TBD** | **TBD** |
| False positives | **Requires answer key validation** | **Requires answer key validation** | **TBD** | **TBD** |
| False positive rate | **Calculate:  FP/(TP+FP)** | **Calculate: FP/(TP+FP)** | **TBD** | **TBD** |

**Observations from Raw Data:**

1. **High variability in solo performance**: One solo reviewer (Tomek) reported 20 defects in Code 1, while Kasia P. reported only 1.  This suggests individual differences are substantial.

2. **High variability in pair performance**: Tomek + Kasia pair reported 52 defects in Code 2, while other pairs reported 1-3 defects. This requires investigation into whether these are valid defects or false positives.

3. **Potential outliers**: 
   - Tomek (solo, 20 defects in Code 1 ; 52 in pair)

4. **Data quality concerns**:
   - Some entries show ranges (e.g., "47-51", "77-96") which may indicate multiple lines for one defect
   - Duplicate entries (e.g., line 105 appears twice for Tomek, line 526 twice for Kasia P.  + Tomek)

### Hypotheses Testing

**Statistical Test Selection:**

Given the within-subjects repeated measures design, the following tests should be selected:

**For H1 and H2**:  Paired t-test (parametric) or Wilcoxon signed-rank test (non-parametric)
- Justification: Within-subjects design with continuous dependent variables
- Assumption checks: **You must perform Shapiro-Wilk normality tests** on: 
  - Differences in defect counts (pair - solo) for each participant
  - This tests the normality of the *difference scores*, which is the key assumption for paired t-tests

**Steps You Must Complete:**

1. **Validate all reported defects** against the answer key for both Code 1 and Code 2
2. **Create a paired dataset**:  Each participant has one solo score and one pair score
3. **Calculate difference scores**: For each participant, compute (pair defects - solo defects)
4. **Test normality**:  Apply Shapiro-Wilk test to the difference scores
5. **Choose appropriate test**:
   - If p > 0.05 in Shapiro-Wilk: Use paired t-test
   - If p ≤ 0.05 in Shapiro-Wilk: Use Wilcoxon signed-rank test

**Assumption Testing:**

**Requirements for you to complete:**

- Normality (Shapiro-Wilk test on difference scores): **You must calculate this**
  - H₀:  Difference scores are normally distributed
  - If W statistic and p-value show p > 0.05, normality assumption is met
  - Decision: Use parametric (t-test) if p > 0.05; use non-parametric (Wilcoxon) if p ≤ 0.05

**H1:  Defect Detection Effectiveness**

*Null Hypothesis (H1₀)*: μ_pair = μ_solo

*Alternative Hypothesis (H1₁)*: μ_pair > μ_solo (one-tailed)

**Requirements for you to complete:**

1.  Validate defects against answer key to get true positive counts
2. Create paired dataset with each participant's solo and pair scores
3. Calculate difference scores (pair - solo)
4. Test normality of differences using Shapiro-Wilk
5. Choose and perform appropriate test: 
   - **Paired t-test** (if normally distributed): 
     - Calculate t-statistic = (mean difference) / (SE of difference)
     - df = n - 1
     - Find p-value from t-distribution
   - **Wilcoxon signed-rank test** (if not normally distributed):
     - Rank the absolute differences
     - Calculate W statistic
     - Find p-value

6. Calculate effect size (Cohen's d):
   - d = (mean difference) / (SD of differences)
   - Interpret: |d| < 0.5 = small, 0.5-0.8 = medium, > 0.8 = large

7. Decision criteria:
   - If p < 0.05: Reject H1₀, conclude pairs found significantly more defects
   - If p ≥ 0.05: Fail to reject H1₀, no significant difference

**Template for reporting (once you complete calculations):**

- Test used: [Paired t-test / Wilcoxon signed-rank test]
- Test statistic: [t / W] = **[YOUR CALCULATION]**
- Degrees of freedom (if applicable): df = **[n - 1]**
- p-value: p = **[YOUR CALCULATION]**
- Effect size (Cohen's d): d = **[YOUR CALCULATION]**
- Decision: [Reject / Fail to reject] H1₀ at α = 0.05
- Interpretation: **[Based on your results, state whether pairs found significantly more defects, and the magnitude of the effect]**

**H2: Time Efficiency**

**IMPORTANT NOTE:** Your data tables do **not** contain any time measurements. The experiment tracked:
- Time to first defect
- Average time between defects
- Total session time

**These metrics are not available in the provided tables.**

**You have two options:**

1. **If you have timing data elsewhere**: Complete the same analysis procedure as H1:
   - Test normality of time difference scores
   - Perform paired t-test or Wilcoxon test
   - Calculate effect size
   - Report results

2. **If you do NOT have timing data**: Remove this entire section from the report, including: 
   - H2 hypothesis from the Experiment Design section
   - RQ2 from the Research Questions
   - All references to time efficiency throughout the document
   - "Average time between defects" from dependent variables

**If timing data exists (to be completed by you):**

*Null Hypothesis (H2₀)*: μ_time_solo = μ_time_pair

*Alternative Hypothesis (H2₁)*: μ_time_solo < μ_time_pair (one-tailed)

- Test used: **[You must determine based on normality test]**
- Test statistic: **[YOUR CALCULATION]**
- p-value: p = **[YOUR CALCULATION]**
- Effect size: d = **[YOUR CALCULATION]**
- Decision: **[YOUR CONCLUSION]**
- Interpretation: **[YOUR INTERPRETATION]**

**If timing data does NOT exist:**

**Remove this hypothesis entirely and update RQ2.**

**Power Analysis:**

**Note:** Power analysis should be performed for non-significant results to determine if the sample size was adequate.

**You must calculate:**

For each non-significant result (if any):
- Observed effect size:  **[Calculate Cohen's d from your data]**
- Sample size:  N = 11 pairs
- Achieved power (1-β): **[Use G*Power, R pwr package, or online calculator]**
  - Input: effect size, n, α = 0.05, test type (paired)
- Minimum detectable effect size at 80% power: **[Calculate using power analysis software]**
  - Input: n = 11, α = 0.05, power = 0.80

**Interpretation guidance:**
- If achieved power < 0.80 and result is non-significant: Your sample size may be too small to detect a real effect (Type II error risk)
- If achieved power ≥ 0.80 and result is non-significant: You had adequate power, suggesting the effect is truly absent or very small

**Additional Analyses:**

**False Positive Rate Comparison:**

**You must calculate:**

1. For each participant/pair, determine false positive rate: 
   - FP rate = (# false positives) / (# true positives + # false positives)
   - This requires validating each reported line number against the answer key

2. Calculate descriptive statistics: 
   - Mean FP rate (Solo): **[YOUR CALCULATION]** ± **[SD]**
   - Mean FP rate (Pair): **[YOUR CALCULATION]** ± **[SD]**

3. Statistical test (same procedure as H1):
   - Test normality of FP rate differences
   - Perform paired t-test or Wilcoxon signed-rank test
   - Result: **[t/W statistic, p-value, interpretation]**

**Template for reporting:**
- Mean FP rate (Solo): **[X. XX%]** (SD = **[X.XX]**, Range = **[X.XX-X.XX]**)
- Mean FP rate (Pair): **[X.XX%]** (SD = **[X.XX]**, Range = **[X.XX-X.XX]**)
- Statistical test: **[Test name]**
- Result: **[Statistic] = [value], p = [value]**
- Interpretation:  Pairs had [significantly higher/lower/similar] false positive rates compared to solo reviewers, [interpretation if significant]

### Interpretation of Results

**IMPORTANT:** The interpretation below is a **template**. You must replace all bracketed sections with your actual findings after completing the statistical analyses.

**Main Findings:**

**RQ1: Do pairs find more defects? **

**[Complete after performing H1 analysis]**

Template:
- The results **[show/do not show]** that pairs found significantly more defects than solo reviewers. 
- On average, pairs detected **[X.XX ± SD]** valid defects while solo reviewers detected **[X. XX ± SD]** valid defects.
- The effect size was **[small/medium/large]** (Cohen's d = **[X.XX]**).
- **[If significant]:** This supports the hypothesis that collaboration improves defect detection.  The magnitude of the effect suggests **[practical significance interpretation]**. 
- **[If not significant]:** This does not support the hypothesis that pairs are more effective.  However, power analysis showed **[interpretation of power]**. 

**RQ2: Is solo review faster? **

**[Only complete if timing data exists; otherwise DELETE this section]**

Template:
- Solo reviewers **[were/were not]** significantly faster in finding the first defect.
- The average time to first defect was **[X.XX ± SD]** minutes for solo vs.  **[X.XX ± SD]** minutes for pairs.
- **[If significant]:** This suggests a time efficiency trade-off:  pairs may find more defects but take longer. 
- **[If not significant]:** Time efficiency was similar between approaches.

**Secondary Findings:**

1. **False Positive Rates**:  

**[Complete after false positive analysis]**

Template:
- Solo reviewers had a mean false positive rate of **[X.XX%]** (SD = **[X.XX]**), compared to **[X.XX%]** (SD = **[X. XX]**) for pairs.
- **[If significant difference]:** Pairs had **[significantly fewer/more]** false alarms (p = **[X.XX]**), suggesting **[interpretation:  e.g., "more careful validation" or "tendency to report marginal issues"]**.
- **[If not significant]:** Both approaches had similar accuracy in distinguishing real defects from non-issues.

2. **Individual Variability**: 

The data shows extremely high variability within both conditions: 
- **Solo performance**: Ranged from 0-20 reported defects in raw data, with Tomek reporting 20x more defects than Kasia P. in Code 1
- **Pair performance**: Ranged from 1-52 reported defects, with Tomek + Kasia reporting 26x more defects than Mateusz + Piotr in their respective codes

**Implications:**
- Individual/pair differences may be larger than the solo vs. pair effect
- Experience, thoroughness, or understanding of "what counts as a defect" varied greatly

3. **Data Quality Concerns**:

Several issues noted:
- Duplicate line numbers within same participant (e.g., Tomek:  line 105 twice)
- Range notations (e.g., "47-51", "77-96") suggest unclear reporting protocol
- High defect counts for Tomek + Kasia (52 defects) vs. others (1-5) suggests possible different interpretation of task

**Recommendations:**
- Data validation is critical before analysis
- Investigate Tomek + Kasia's 52 defects:  Are these all valid?  Did they apply different criteria? 

**Practical Implications:**

**[Complete based on your actual results.  Below is a template with multiple scenarios]**

**Scenario A: If pairs found significantly more defects with acceptable time cost:**
- The results suggest that pair code review is more effective for defect detection than solo review. 
- For software development teams, this implies: 
  1. **Critical code sections** (e.g., security, core algorithms) should be reviewed in pairs
  2. **Less critical code** might be reviewed solo to save resources
  3. **Training** should emphasize collaborative review techniques
  4. **Resource allocation**:  The cost of pairing may be offset by fewer bugs reaching production

**Scenario B: If no significant difference was found:**
- The results do not show a clear advantage for pair code review.
- For software development teams, this implies:
  1. **Solo review may be sufficient** for many contexts, allowing more parallel reviews
  2. **Individual reviewer skill** may matter more than working mode
  3. **Pair review** could still be valuable for **knowledge sharing** and **mentoring**, even if not more effective for defect detection
  4. **Cost-effectiveness**: Solo review requires half the person-hours for similar results

**Scenario C: If high variability dominated the results:**
- Individual differences in reviewer skill/thoroughness were larger than the solo vs. pair effect.
- For software development teams, this implies: 
  1. **Reviewer training** and **clear defect criteria** are critical
  2. **Calibration sessions** where reviewers discuss what constitutes a defect
  3. **Review checklists** to standardize the review process
  4. **Quality metrics** for reviewers themselves (not just code)

**Comparison with Literature:**

**[Optional: If you have time, compare your findings to these examples]**

Relevant prior research:
- **Pair programming studies** (e.g., Williams & Kessler, 2000) found pairs write higher quality code but at a 15% time cost
- **Code review effectiveness** studies (e.g., Porter et al., 1998) suggest individual preparation followed by group discussion is most effective
- **Inspection studies** (e.g., Fagan, 1976) emphasize the importance of reviewer training and clear defect taxonomies

**Your findings [support/contradict/extend] this literature by.. .**

---

## Threats to Validity

This section discusses potential threats to the validity of our findings and the measures taken to mitigate them. 

### Conclusion Validity

Conclusion validity concerns whether we can correctly infer a relationship between treatment and outcome. 

**Threat 1: Small Sample Size**

- *Description*: With 11 participants, statistical power may be limited to detect small effects. 
- *Mitigation*:  Within-subjects design was chosen to increase statistical power by controlling for individual differences.  Each participant served as their own control, effectively maximizing information from the available sample. 
- *Residual risk*: **[Complete power analysis]**.  If power was insufficient (< 0.80), we acknowledge that non-significant results may represent Type II errors rather than true null effects.  With n=11 pairs, we can detect effect sizes of **[calculate minimum detectable effect size]** at 80% power. 
- *Impact*: Given the **very high variability** observed in the data (e.g., 0-20 defects solo, 1-52 defects pairs), small effects may be obscured by noise.

**Threat 2: Reliability of Measurements**

- *Description*: Defect classification involves subjective judgment, which could introduce measurement error.
- *Mitigation*: A detailed answer key was prepared in advance with clear criteria for each defect.  
- *Residual risk*: **Medium**. The high variability in reported defects (especially Tomek + Kasia reporting 52 vs. others reporting 1-5) suggests:
  - Participants may have interpreted "defect" differently
  - The answer key validation will reveal how many reported issues were actually valid defects

**Threat 3: Violation of Statistical Test Assumptions**

- *Description*:  Parametric tests assume normality of distributions (specifically, difference scores in paired tests).
- *Mitigation*: **[You must complete]** Normality was tested using Shapiro-Wilk test. If assumptions are violated, non-parametric alternatives (Wilcoxon signed-rank test) will be used.
- *Residual risk*:  Minimal, as appropriate tests will be selected based on data characteristics.  However, **outliers** (Tomek's 20 defects, Tomek + Kasia's 52 defects) may distort the distribution even in non-parametric tests. 

**Threat 4: Outliers and Data Quality**

- *Description*:  Extreme values and suspicious entries threaten the validity of conclusions.
- *Issues identified*:
  2. Tomek + Kasia reported 52 defects vs. 1-9 for all others
  3. Tomek reported 20 defects solo vs. 0-2 for others
  4. Range notations ("47-51") suggest unclear reporting
  5. Duplicate entries within participants
- *Mitigation*: **You must:**
  1. Validate all line numbers against answer key
  2. Investigate unusual entries with experimenter notes
  3. Consider sensitivity analysis:  Run analyses with and without outliers
  4. Check for data entry errors
- *Residual risk*: **High** until validation is complete. Invalid data could severely bias results. 

### Internal Validity

Internal validity concerns whether the observed effects can be attributed to the independent variable rather than confounding factors.

**Threat 1: Learning Effects**

- *Description*:  Participants might improve their code review skills between Session 1 and Session 2, potentially confounding treatment effects with learning effects.
- *Mitigation*: Counterbalancing was implemented: 
  - Group 1: Solo (Code 1) → Pair (Code 2)
  - Group 2: Pair (Code 1) → Solo (Code 2)
- *Impact analysis*: **[You should check]:**
  - Did Group 1 find more defects in Session 2 (Code 2) than Group 2 found in Session 2? 
  - If yes, learning effects may be present but balanced
- *Residual risk*: **Low**, assuming counterbalancing worked.  Learning effects should affect both conditions equally.

**Threat 2: Fatigue Effects**

- *Description*:  Participants might perform worse in Session 2 due to mental fatigue from Session 1.
- *Mitigation*: 
  - A 5-minute break was provided between sessions
  - Each session was limited to 30 minutes to prevent excessive fatigue
  - Counterbalancing ensures fatigue affects both conditions equally
- *Analysis*: **[You should check]:** Did participants find fewer defects in Session 2 overall, regardless of condition?
- *Residual risk*: **Low** to **Medium**. 30-minute sessions are relatively short, but mental fatigue from code review can accumulate.  Counterbalancing should distribute this effect equally. 

**Threat 3: Code Difficulty Imbalance**

- *Description*: If Code 1 and Code 2 differ substantially in difficulty, this could confound results.
- *Mitigation*: 
  - Both codes were designed with 10 defects each
  - Similar length (~500 LOC claimed, though line numbers suggest ~200-500)
  - Similar domains (data structures vs. security)
  - Counterbalancing:  Each code was reviewed by both solo and pair conditions
- *Analysis*: **[You should compare]:**
  - Average defects found in Code 1 (across solo + pair) vs. Code 2 (across solo + pair)
  - If Code 1 consistently yields more/fewer defects, difficulty may differ
- *Residual risk*:  **Low**, due to counterbalancing. Even if codes differ in difficulty, both solo and pair reviewed each code. 

**Threat 4: Hawthorne Effect**

- *Description*: Participants may alter their behavior because they know they are being observed and studied.
- *Mitigation*:  Participants were told the study's general purpose without revealing specific hypotheses about pair superiority, reducing demand characteristics.
- *Residual risk*: **High**. Participants knew they were being evaluated, which may have increased motivation in both conditions.  However, this effect should be consistent across conditions. 
- *Observation*: The very high defect counts for some participants (Tomek:  20, Tomek + Kasia: 52) may reflect **over-reporting** due to Hawthorne effect (trying to appear thorough).

**Threat 5: Pair Dynamics Variability**

- *Description*:  Different pairs may have vastly different collaboration dynamics (dominant vs. balanced), introducing noise in the pair condition.
- *Evidence*: The pair condition shows **extreme variability**:
  - Dominik + Kasia R.:  2 defects
  - Mateusz + Piotr:  1 defect
  - Ola + Dominika: 2 defects
  - Kasia P. + Tomek: 3-9 defects (uncleardue to duplicates)
  - **Tomek + Kasia: 52 defects** (26x more than some pairs!)
- *Mitigation*: 
  - Post-experiment survey measured pair dynamics
  - **[You should analyze survey data]** to see if Tomek + Kasia reported different collaboration patterns
  - Pairs were formed by participant preference
- *Residual risk*:  **Very High**. The enormous difference in pair performance (1-2 vs. 52 defects) suggests:
  1. Pair dynamics strongly influence results
  2. Tomek + Kasia may have used a different strategy or criteria
  3. Some "defects" reported by Tomek + Kasia may be false positives
- *Recommendation*: **You must:**
  1. Validate Tomek + Kasia's 52 defects against answer key
  2. Check if they reported different types of defects (e.g., style vs. logic)
  3. Consider sensitivity analysis excluding this outlier pair

**Threat 6: Task Understanding Variability**

- *Description*: Participants may have understood "what counts as a defect" differently. 
- *Evidence*: 
  - Tomek + Kasia: 52 defects vs. 1-9 for all others
  - Range notations ("47-51", "77-96"): Suggests different reporting interpretations
  - Tomek: 20 defects solo vs. 0-2 for other solo reviewers
- *Mitigation*: 
  - Defect categories guide was provided
  - Instructions clarified reporting protocol
  - Answer key defines ground truth
- *Residual risk*: **Very High**. The data strongly suggests different interpretations: 
  - Some may have reported every minor style issue
  - Others may have focused only on critical bugs
  - This is a **major threat** that could invalidate comparisons
- *Recommendation*: **You must:**
  1. Categorize defects by type (using answer key): security, logic, style, etc. 
  2. Check if high-count participants reported more style issues
  3. Consider analyzing only critical defects (severity filter)
  4. Include defect type in analysis

### Construct Validity

Construct validity concerns whether the measured variables truly represent the theoretical constructs of interest.

**Threat 1: Artificially Inserted Defects**

- *Description*:  Deliberately inserted defects may not reflect the distribution and subtlety of real-world bugs.
- *Mitigation*: Defects were chosen to represent common, realistic issues found in actual code reviews (null pointer exceptions, security vulnerabilities, logic errors, memory leaks, style violations).
- *Residual risk*: **Moderate**. Real code reviews involve: 
  - Unknown numbers of defects
  - Natural distribution of defect types
  - Ambiguous cases where "is this a bug?" is subjective
- *Impact*: This study measures "defect detection given exactly 10 known defects," which may not generalize to "defect detection in real code with unknown defect count."

**Threat 2: Defect Counting as Sole Metric**

- *Description*:  Counting defects assumes all defects are equally important, which is not true in practice.
- *Evidence from design*:  Defects were assigned severities (Critical, Major, Minor), but analysis treats all defects equally.
- *Mitigation*: **[You could improve analysis by]:**
  - Weighting defects by severity:  e.g., Critical = 3 points, Major = 2, Minor = 1
  - Analyzing only Critical + Major defects
  - Reporting defect detection by severity category
- *Residual risk*: **Moderate**. Finding 5 critical bugs is more valuable than finding 10 minor style issues, but simple defect count doesn't capture this. 

**Threat 3: Time Limit Effects**

- *Description*:  The 30-minute time limit may not reflect typical code review conditions and may introduce strategic trade-offs.
- *Impact*: 
  - Participants may prioritize **reporting many defects quickly** over **carefully validating each defect**
  - This could explain high false positive rates (if observed)
  - Pairs may communicate more slowly, finding fewer defects not due to effectiveness but due to communication overhead
- *Mitigation*: Time limit was the same for both conditions. 
- *Residual risk*: **Moderate**. Real code reviews may be more relaxed (unlimited time) or more rushed (tight deadline), changing the optimal strategy.

**Threat 4: Pair vs. Solo Construct Clarity**

- *Description*: "Pair code review" as implemented may not represent how pairs actually work in industry.
- *Implementation*: Driver-navigator pattern, single computer, verbal reporting
- *Real-world variation*: 
  - Some teams do asynchronous pair review (sequential review by two people)
  - Some use collaborative tools (e.g., GitHub PR reviews with two reviewers commenting)
  - Some pairs work independently then discuss findings
- *Residual risk*: **Moderate**. Results apply to synchronous driver-navigator pair review, which is one form of collaborative review but not the only one.

### External Validity

External validity concerns the generalizability of findings to other contexts, populations, and settings.

**Threat 1: Student Sample**

- *Description*: 5th-year computer science students may differ from professional software developers in experience, motivation, domain knowledge, and code review skills.
- *Mitigation*: 
  - Participants were senior students with several years of programming experience
  - Demographic data was collected to characterize the sample
  - Results are explicitly framed as applicable to this population
- *Residual risk*: **Very High**.  Generalization to professional developers requires caution:
  - Professionals have more code review experience
  - Professionals have domain expertise (e.g., security specialists reviewing authentication code)
  - Professionals may be more motivated (their code goes to production)
  - Professionals may have better-calibrated understanding of "what is a defect"
- *Recommendation*:  Clearly state in conclusions that results apply to students and replication with professionals is needed.

**Threat 2: Laboratory Setting**

- *Description*: The controlled laboratory environment differs from real software development settings.
- *Differences*:
  - Real reviews involve broader context (project history, previous discussions, documentation)
  - Real reviewers may have written some of the code being reviewed
  - Real reviews may involve more than 2 people (e.g., senior developer + two juniors)
  - Real reviews may be asynchronous (GitHub PRs reviewed over days)
- *Mitigation*:  GitHub Codespaces provided a realistic development environment, and tasks were designed to simulate actual code review. 
- *Residual risk*: **High**. Real code reviews are embedded in a development workflow with more context and social dynamics.  Results may not generalize to asynchronous, distributed, or multi-stakeholder reviews.

**Threat 3: Limited Code Samples**

- *Description*: Only two code samples in Java were used; results may not generalize to other programming languages, paradigms, or domains.
- *Mitigation*: Code samples represented different domains (data structures vs. security) to increase variety.
- *Residual risk*: **Very High**. Generalization is limited: 
  - **Language**:  Java vs. Python, JavaScript, C++, etc. 
  - **Paradigm**: Object-oriented vs. functional programming
  - **Domain**: System programming, web development, data science, embedded systems
  - **Code characteristics**: Length, complexity, style
- *Recommendation*: State clearly that results apply to medium-length Java code in academic context.  Replication with other languages and domains needed.

**Threat 4: Task Specificity**

- *Description*:  Findings apply to defect detection in code review but may not generalize to other collaborative programming activities.
- *Comparison*: 
  - **Pair programming** (writing code together): May benefit more from pair collaboration due to real-time problem-solving
  - **Architectural design**:  May benefit from diverse perspectives in pairs
  - **Debugging**: May benefit from "rubber duck" effect of explaining to partner
  - **Code review** (this study): Pairs may or may not find more defects
- *Residual risk*:  **Moderate** for code review context; **High** for other activities.

**Threat 5: Cultural and Educational Context**

- *Description*: The study was conducted at Poznan University of Technology with Polish computer science students.  Educational systems, programming training, and cultural norms around collaboration vary globally.
- *Residual risk*: **Moderate**. Results may not generalize to students in other countries or educational systems. 

### Summary of Validity Assessment

**Strengths of the experimental design:**
1. ✓ **Within-subjects design** with counterbalancing controls for individual differences and order effects
2. ✓ **Structured protocol** with clear instructions and answer key
3. ✓ **Realistic task** using actual Java code with embedded defects
4. ✓ **Controlled environment** (GitHub Codespaces, time limits)

**Critical limitations:**
1. ✗ **Very small sample** (n=11) limits statistical power and generalizability
3. ✗ **Student sample** limits generalization to professional developers
4. ✗ **Pair dynamics variability** threatens internal validity
5. ✗ **Task understanding differences** may have caused participants to use different defect criteria
6. ✗ **Limited external validity** (only Java, only academic setting, only 2 code samples)

**Most critical threat:**
The **extreme variability** in reported defects (0-52 range) combined with **suspicious data points** is the most serious threat.  **Before drawing any conclusions, you must:**
1. **Validate every reported line number** against the answer key
2. **Investigate outliers**
3. **Clean the data**
4. **Consider task understanding** as a confound:  Did participants interpret "defect" consistently? 

**Recommendation:** Add a "Limitations" subsection to the Conclusions section explicitly discussing these threats and their impact on interpreting results.

---

## Conclusions

**[IMPORTANT: Complete this section AFTER you have:]**
1. **Validated all defects against the answer key**
2. **Calculated true positive and false positive rates**
3. **Performed statistical tests (normality, hypothesis tests, effect sizes)**
4. **Analyzed outliers and data quality**
5. **Interpreted your results**

**Template (adjust based on your actual findings):**

This experiment investigated the effectiveness of pair code review compared to solo code review in terms of defect detection using a within-subjects repeated measures design with 11 participants (5th-year Computer Science students at Poznan University of Technology).

**Key Findings:**

1. **[Defect Detection (H1)]**: 
   - **[State your finding]**: Pairs found **[significantly more/similar numbers of/fewer]** defects compared to solo reviewers. 
   - **[Report statistics]**: Mean defects for pairs = **[X.XX ± SD]**, solo = **[X.XX ± SD]**, **[test name]** **[statistic]** = **[value]**, p = **[value]**, Cohen's d = **[value]**. 
   - **[Interpret effect size]**: The effect size was **[small/medium/large/negligible]**, suggesting **[practical significance statement]**.

2. **[Time Efficiency (H2) - if data available]**:
   - **[State your finding]**: Solo review was **[significantly faster/similar speed/slower]** than pair review. 
   - **[Report statistics]**:  **[Include your statistics here]**
   - **[Interpret]**: **[Practical implications of time findings]**

3. **[False Positive Rates]**:
   - **[State your finding]**: Pairs had **[higher/similar/lower]** false positive rates compared to solo. 
   - **[Report rates]**: Solo FP rate = **[X.XX%]**, Pair FP rate = **[X.XX%]**
   - **[Interpret]**: **[What does this mean for accuracy/precision? ]**

4. **Individual Variability**:
   - Extremely high variability was observed in both conditions (solo: **[range]** defects, pair: **[range]** defects).
   - This suggests that **individual/pair differences may be as important or more important than work mode** in determining review effectiveness. 
   - Possible explanations: Different interpretations of "defect," varying thoroughness, experience differences, or task understanding issues.

**Theoretical Contributions:**

**[Choose appropriate interpretation based on your results]:**

**If pairs were more effective:**
- This study provides empirical support for collaborative code review in detecting defects.
- The findings align with theories of collaborative problem-solving, suggesting that **dialogue and multiple perspectives** help identify issues that individuals might overlook.
- The benefit comes at a potential cost (time or doubled person-hours), creating a **quality-efficiency trade-off**.

**If no significant difference:**
- This study suggests that for straightforward defect detection tasks, **individual cognitive capacity may be sufficient**. 
- The lack of pair advantage may reflect that code review is more of an **individual analytical task** (like proofreading) rather than a **collaborative creative task** (like design).
- Individual reviewer **skill and training** may matter more than working mode. 

**If high variability dominated:**
- This study highlights the **critical importance of reviewer calibration and training**. 
- The enormous variation (some participants found 0-2 defects, others found 20-52) suggests that **standardizing the review process** and **clarifying defect criteria** are essential.
- Organizations should focus on **improving reviewer consistency** rather than simply mandating pair reviews.

**Practical Implications:**

**[Adjust based on your results.  Provide actionable recommendations for software teams]**

For software development teams, these findings suggest: 

1. **[Based on your H1 result]**:
   - **If pairs were more effective**: Use pair review for critical code (security, core algorithms, complex logic) and solo review for routine code. 
   - **If no difference**: Solo review may be more cost-effective, allowing parallel reviews of multiple components.
   - **If inconclusive**: Focus on reviewer training and defect checklists rather than mandating work mode. 

2. **Reviewer Training is Critical**:
   - The high variability observed indicates that **individual reviewer skill/thoroughness varies enormously**.
   - Invest in: 
     - **Calibration sessions**:  Reviewers discuss sample code to align on "what is a defect"
     - **Review checklists**: Standardized lists of common defect types to check
     - **Defect taxonomies**: Clear categories (security, logic, performance, style) with examples
     - **Metrics and feedback**: Track individual reviewer performance to identify training needs

3. **Context Matters**:
   - **Code complexity**: More complex code may benefit more from pair review
   - **Domain expertise**: Reviewers unfamiliar with a domain may need pair support
   - **Time constraints**: If time is limited, solo review allows more parallel coverage

4. **Consider Hybrid Approaches**:
   - **Sequential review**: Two individuals review independently, then discuss findings (may combine benefits of both)
   - **Selective pairing**: Pair junior and senior reviewers for knowledge transfer
   - **Tool support**: Use automated tools (linters, static analyzers) to catch routine defects, reserving human review for complex logic

**Limitations:**

The main limitations of this study include:

1. **Small sample size** (n=11 participants) limits statistical power and generalizability.
   - **[Report achieved power]**: Power analysis showed achieved power of **[X.XX]** for the observed effect size.
   - Non-significant results may reflect insufficient power rather than true absence of effects (Type II error risk).

2. **Student participants** rather than professional software developers. 
   - Students may have less code review experience and domain knowledge.
   - Professionals may show different patterns due to expertise and motivation. 
   - **Caution**: Results may not generalize to industry settings. 

3. **Controlled laboratory setting** with artificial constraints.
   - Real code reviews involve more context (project history, documentation, architecture knowledge).
   - 30-minute time limit may have encouraged speed over accuracy.
   - Real reviews are often asynchronous and distributed.

4. **Limited code samples** (only 2 Java programs, ~500 LOC each).
   - Results may not generalize to other languages (Python, JavaScript, C++), paradigms (functional programming), or domains (web development, embedded systems).
   - Code complexity and domain affect review difficulty. 

5. **Data quality concerns**:
   - **[If outliers were present]**: Extreme outliers (e.g., **[participant X reporting Y defects]**) may distort results.
   - **[If task understanding varied]**: Different interpretations of "what is a defect" may have confounded comparisons.

6. **Pair dynamics variability**:
   - The pair condition showed enormous variability (**[range]** defects), suggesting that **how** pairs collaborate matters as much as **whether** they collaborate.
   - Some pairs may have had poor dynamics (one person dominant, poor communication).

7. **Missing time data** (if applicable):
   - **[If you deleted H2]**: Time efficiency could not be analyzed due to lack of timing measurements.
   - Future studies should track time to assess cost-benefit trade-offs.

**Future Work:**

To build on this exploratory study, future research should: 

1. **Replication with larger sample**:
   - Target n≥30 to achieve adequate statistical power (≥0.80) for medium effect sizes.
   - Use power analysis to determine required sample size based on observed effect size from this study:  d = **[your Cohen's d]**.

2. **Professional developer sample**:
   - Conduct the same experiment with experienced software engineers in industry.
   - Compare student vs. professional performance to assess generalizability. 
   - Investigate whether experience moderates the solo vs. pair effect.

3. **Broaden code samples**:
   - Multiple programming languages (Python, JavaScript, C++, Go)
   - Different paradigms (object-oriented, functional, procedural)
   - Varying complexity levels (simple scripts to complex systems)
   - Different domains (web apps, data science, embedded systems, security-critical code)

4. **Longer-term naturalistic studies**:
   - Observational studies of real code review in industry (e.g., GitHub PR reviews)
   - Collect data on defects found, time spent, false positives, and defects that escaped to production
   - Control for confounds (code complexity, reviewer experience) through statistical modeling

5. **Investigate pair dynamics**:
   - What makes some pairs highly effective (52 defects) and others less so (1-2 defects)?
   - Study communication patterns, division of labor, and decision-making in pairs. 
   - Develop guidelines for effective pair code review (e.g., "ensure both people actively participate").

6. **Hybrid approaches**:
   - Compare solo, pair, and sequential-then-discuss review methods.
   - Test tool-supported review (linters + human review) vs. pure human review.
   - Investigate optimal team sizes (2 vs. 3 vs. 4 reviewers).

7. **Defect severity weighting**:
   - Analyze not just defect count, but weighted defect score (Critical=3, Major=2, Minor=1).
   - Investigate whether pairs are better at finding critical vs. minor defects. 
   - Study reviewer calibration:  Do pairs agree more on severity ratings? 

8. **Cost-benefit analysis**:
   - Model the trade-off:  (defects found × defect fix cost in production) vs. (review time cost).
   - Determine ROI breakeven point:  When does pair review pay off economically? 

9. **Reviewer training interventions**:
   - Randomized controlled trial:  Trained vs. untrained reviewers, solo vs. pair. 
   - Develop and evaluate training programs for effective code review.
   - Measure training impact on consistency and defect detection. 

10. **Meta-analysis**:
    - Combine this study with future replications for aggregate effect size estimation.
    - Investigate moderators:  experience, code type, review duration. 

**Final Conclusion:**

**[Write 2-3 sentences summarizing the key takeaway, adjusted for your actual findings.  Examples below]**

**Example A (if pairs were better):**
This study provides preliminary evidence that pair code review can improve defect detection compared to solo review, with a **[small/medium/large]** effect size (d = **[X.XX]**). However, the small sample size (n=11), student population, and high variability limit generalizability. Software teams should consider pair review for critical code while investing in reviewer training and calibration to reduce the large individual differences observed in this study.

**Example B (if no difference):**
This study found no significant difference in defect detection between pair and solo code review (p = **[X.XX]**, d = **[X.XX]**). The high variability in individual/pair performance suggests that reviewer skill and task understanding may matter more than work mode. Software teams should focus on reviewer training, clear defect criteria, and efficient allocation of review resources rather than mandating pair reviews.  Replication with larger samples and professional developers is needed to confirm these findings.

**Example C (if inconclusive due to data issues):**
This exploratory study revealed substantial challenges in measuring code review effectiveness, including high variability in reviewer performance, potential differences in task understanding, and data quality issues. While the study provides initial data on solo vs. pair code review (mean defects:  solo = **[X.XX]**, pair = **[X.XX]**), the small sample (n=11) and methodological limitations prevent strong conclusions. The most important finding may be that **reviewer calibration and clear defect definitions are critical** for valid comparisons.  Future research should address these methodological challenges while investigating the conditions under which pair review is most beneficial.

---

**Data Availability Statement:**

**[Choose appropriate statement]**

- The raw data collected in this experiment, including participant responses and defect reports, are available upon request from the authors.
- **OR**:  The data are available in the supplementary materials / GitHub repository:  **[URL]**
- **OR**: The data contain potentially identifying information about participants and are therefore not publicly available, but aggregate statistics are reported in this paper.

**Conflict of Interest Statement:**

The authors declare no conflicts of interest. 

**Acknowledgments:**

We thank the participants who volunteered their time for this experiment, and the instructors of the Quality Management and Experimental Software Engineering course at Poznan University of Technology for their guidance and support.

---

**References**

*[Optional: Add if you cited any sources]*

- Fagan, M. E. (1976). Design and code inspections to reduce errors in program development.  *IBM Systems Journal*, 15(3), 182-211.
- Porter, A., Siy, H., Toman, C.  A., & Votta, L. G. (1997). An experiment to assess the cost-benefits of code inspections in large scale software development. *IEEE Transactions on Software Engineering*, 23(6), 329-346.
- Williams, L., & Kessler, R. (2000). All I really need to know about pair programming I learned in kindergarten. *Communications of the ACM*, 43(5), 108-114.

---

## Appendices

### Appendix A: Raw Data Tables

**[Data table in the github repository]**

**Code 1 - Solo Reviewers:**

| Participant | Reported Line Numbers | Count |
|-------------|----------------------|-------|
| Kasia P.  | 196 | 1 |
| Tomek | 464, 480, 481, 6, 7, 12, 24, 42, 60, 72, 74, 78, 87, 105, 108, 111, 105, 136, 143, 151, 159, 187 | 20 (with 1 duplicate) |
| Ola | 464, 357 | 2 |
| Erasmus | 464, 145 | 2 |

**Code 1 - Pair Reviewers:**

| Pair | Reported Line Numbers | Count |
|------|----------------------|-------|
| Dominik + Kasia R. | 195, 291 | 2 |
| Mateusz + Piotr | 358 | 1 |

**Code 2 - Solo Reviewers:**

| Participant | Reported Line Numbers | Count |
|-------------|----------------------|-------|
| Kasia R. | 19, 153, 419 | 3 |
| Dominik | 19, 47-51, 77-96 | 3|
| Piotr | (none) | 0 |
| Mateusz | 42, 87, 119, 389, 38, 2137, 39 | 7 |

**Code 2 - Pair Reviewers:**

| Pair | Reported Line Numbers | Count |
|------|----------------------|-------|
| Ola + Dominika | 464, 2137 | 2 |
| Kasia P. + Tomek | 526, 526, 528, 535, 536, 537, 538, 539, 544, 16, 24, 17, 19, 20, 21, 25, 26, 30, 34, 40, 41, 44, 50, 52, 58, 68, 70, 76, 74, 85, 87, 107, 115, 121, 129, 135, 143, 147, 187, 248, 272, 288, 291, 295, 299, 304, 306, 333, 365, 365, 395, 447, 448 | 52 |
| Michal + Erasmus | 524, 127 |

### Appendix B:  Answer Key

## tree_and_binary_search.java Analysis

| Line Number | Code/Issue | Classification | Reasoning |
|-------------|------------|----------------|-----------|
| 196 | `return false;` in findPathHelper | **TP** | **Path not removed from list before returning false** - leaves incorrect path in list |
| 464 | Line doesn't exist | **FP** | Out of bounds |
| 357 | Line doesn't exist | **FP** | Out of bounds |
| 145 | `return countLeavesHelper(tree.getRoot());` | **TP** | **No null check** - crashes on empty tree |
| 195 | `return false;` in findPathHelper | **TP** | Same as 196 - path corruption issue |
| 358 | Line doesn't exist | **FP** | Out of bounds |
| 291 | `if (node.value <= min \|\| node.value >= max)` | **TP** | **Should use < and >** for proper BST validation |
| 480 | Line doesn't exist | **FP** | Out of bounds |
| 481 | Line doesn't exist | **FP** | Out of bounds |
| 6 | `TreeNode right;` | **TP** | **Not final** - should be immutable for safer tree structure |
| 7 | `public TreeNode(int value)` | **FP** | Valid constructor |
| 12 | `if (this == o) return true;` | **FP** | Standard pattern |
| 24 | `this.size = 0;` | **TP** | **Redundant** - default value is already 0 |
| 42 | `private TreeNode insertHelper(...)` | **TP** | **No duplicate handling documented** - silently ignores duplicates |
| 60 | `private boolean searchHelper(...)` | **TP** | **No null check at entry** - will NPE on empty tree |
| 72 | `public void delete(int value)` | **TP** | **Decrements size even if element not found** |
| 74 | `private TreeNode deleteHelper(...)` | **FP** | Valid signature |
| 78 | `if (node == null)` | **FP** | Correct check |
| 87 | `if (node.left == null) return node.right;` | **FP** | Correct logic |
| 105 | `return current.value;` in findMax | **TP** | **No null check** - crashes on empty tree |
| 108 | `public List<Integer> inorderTraversal()` | **FP** | Valid |
| 111 | `return result;` | **FP** | Valid |
| 105 | (duplicate) findMax | **TP** | Same issue - no null check |
| 136 | `return getHeightHelper(root);` | **TP** | **Could cache height** - recalculated every time (inefficient) |
| 143 | `return Math.max(leftHeight, rightHeight) + 1;` | **FP** | Correct calculation |
| 151 | `return size;` | **FP** | Valid getter |
| 159 | `return isBalancedHelper(root) != -1;` | **TP** | **Recalculates every time** - not cached (inefficient) |
| 187 | `return count;` | **FP** | Valid |

## graph_algorithms.java Analysis

| Line Number | Code/Issue | Classification | Reasoning |
|-------------|------------|----------------|-----------|
| 42 | N/A | **FP** | Wrong file |
| 464 | N/A | **FP** | Out of bounds |
| 526 | N/A | **FP** | Out of bounds |
| 524 | N/A | **FP** | Out of bounds |
| 19 | `adjacencyList.get(source).add(...)` | **TP** | **No check if list exists** - could fail if adjacency list corrupted |
| 87 | `int current = queue.poll();` | **FP** | Valid |
| 2137 | N/A | **FP** | huehuehuehuehuehuehue|
| 127 | `if (edges != null)` | **TP** | **Defensive check shouldn't be needed** - indicates design issue |
| 153 | `public int findLongestPath(int start)` | **TP** | **Doesn't work with cycles** - algorithm fundamentally broken for general graphs |
| 47-51 | Constructor loop | **TP** | **Pre-allocating all vertices** - wasteful if graph is sparse |
| 77-96 | dijkstra method | **TP** | **Doesn't handle unreachable vertices clearly** - returns MAX_VALUE |
| 119 | `visited[vertex] = true;` | **FP** | Valid |
| 389 | `findAllPathsUtil(...)` | **TP** | **currentPath shared reference** - all paths point to same list |
| 38 | `visited[start] = true;` | **TP** | **Marked visited too early** - before actually visiting |
| 39 | `while (!queue.isEmpty())` | **FP** | Valid |
| 16 | `adjacencyList = new HashMap<>();` | **TP** | **Could use array** - vertices are integers 0 to n-1 |
| 17 | `for (int i = 0; i < vertices; i++)` | **FP** | Valid |
| 19 | (duplicate) | **TP** | Same as above |
| 20 | `adjacencyList.put(i, new ArrayList<>());` | **TP** | **All lists created upfront** - memory waste for sparse graphs |
| 21 | `}` | **FP** | Valid |
| 24 | `public void addEdge(...)` | **FP** | Valid |
| 25 | `if (source >= vertexCount \|\| destination >= vertexCount)` | **TP** | **Should also check negative values** |
| 26 | `throw new IllegalArgumentException(...)` | **FP** | Appropriate |
| 30 | `public void addBidirectionalEdge(...)` | **TP** | **Adds edge twice** - inefficient, should batch |
| 34 | `public List<Integer> bfs(int start)` | **TP** | **No bounds check on start** - could crash |
| 40 | `queue.offer(start);` | **FP** | Valid |
| 41 | `visited[start] = true;` | **FP** | Valid |
| 44 | `while (!queue.isEmpty())` | **FP** | Valid |
| 50 | `for (Edge edge : neighbors)` | **FP** | Valid |
| 52 | `if (!visited[edge.destination])` | **FP** | Valid |
| 58 | `public List<Integer> dfs(int start)` | **TP** | **No bounds check on start** |
| 68 | `result.add(vertex);` | **FP** | Valid |
| 70 | `List<Edge> neighbors = adjacencyList.get(vertex);` | **FP** | Valid |
| 76 | `public Map<Integer, Integer> dijkstra(int start)` | **TP** | **No bounds check on start** |
| 74 | Previous line | **FP** | Valid |
| 85 | `Node current = pq.poll();` | **FP** | Valid |
| 87 | (duplicate) | **FP** | Valid |
| 107 | `public List<Integer> getShortestPath(...)` | **TP** | **Returns partial path even if unreachable** |
| 115 | `while (!pq.isEmpty())` | **FP** | Valid |
| 121 | `if (current.vertex == end)` | **FP** | Valid optimization |
| 129 | Path reconstruction | **FP** | Valid |
| 135 | `Collections.reverse(path);` | **TP** | **Could build in reverse order** - more efficient |
| 143 | `public boolean hasCycle()` | **TP** | **Checks all vertices unnecessarily** - stops at first cycle but iterates all |
| 147 | `for (int i = 0; i < vertexCount; i++)` | **TP** | **Doesn't check if already visited** - redundant work |
| 187 | `return count;` | **FP** | Valid |
| 248 | `dfsComponent(i, visited, component);` | **FP** | Valid |
| 272 | `dfsLongestPath(...)` | **TP** | **Visited never reset between vertices** - incorrect results |
| 288 | `public boolean pathExists(...)` | **TP** | **Start vertex not marked visited initially** |
| 291 | `return true;` | **FP** | Valid |
| 295 | `visited[current] = true;` | **TP** | **Should mark when adding to queue** - may add duplicates |
| 299 | `List<Edge> neighbors = ...` | **FP** | Valid |
| 304 | `for (Edge edge : neighbors)` | **FP** | Valid |
| 306 | `queue.offer(edge.destination);` | **FP** | Valid |
| 333 | `findAllPathsUtil(...)` | **TP** | **Shared list reference bug** |
| 365 | (duplicate) | **TP** | **Same list reference issue** |
| 365 | (duplicate) | **TP** | Same |
| 395 | `visited[current] = false;` | **FP** | Correct backtracking |
| 447 | `degrees[vertex] = edges.size();` | **TP** | **Only calculates out-degree** - method name misleading |
| 448 | `return degrees;` | **FP** | Valid |

## Summary Statistics

**tree_and_binary_search.java:**
- True Positives: **14** (lines 196, 145, 195, 291, 6, 24, 42, 60, 72, 105 (x2), 136, 159)
- False Positives: **11**

**graph_algorithms.java:**
- True Positives: **29** (lines 19, 127, 153, 47-51, 77-96, 389, 38, 16, 19, 20, 25, 30, 34, 58, 76, 107, 135, 143, 147, 272, 288, 295, 333, 365 (x2), 447)
- False Positives: **30**
---

**END OF REPORT**

**NEXT STEPS TO FINISH THE PROJECT:**
1. ✅ **Calculate descriptive statistics**:
   - Mean ± SD true positives (solo vs.  pair)
   - Mean ± SD false positive rate (solo vs. pair)
2. ✅ **Perform normality test**:  Shapiro-Wilk on difference scores (pair - solo for each participant)
3. ✅ **Conduct hypothesis test**:  Paired t-test or Wilcox
