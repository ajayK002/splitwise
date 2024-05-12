package com.splitwise.SplitWise.strategies;

import com.splitwise.SplitWise.models.Expense;
import com.splitwise.SplitWise.models.ExpenseUser;
import com.splitwise.SplitWise.models.ExpenseUserType;
import com.splitwise.SplitWise.models.User;
import com.splitwise.SplitWise.repositories.ExpenseUserRepository;
import com.splitwise.SplitWise.services.Transaction;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TwoHeapStrategy implements SettleUpStrategy {

    @Autowired
    ExpenseUserRepository expenseUserRepository;

    @Override
    public List<Transaction> settleUp(List<Expense> expenses) {

        List<ExpenseUser> allUsersExpenseForTheseExpenses = expenseUserRepository.findAllByExpenses(expenses);

        HashMap<User, Long> moneyPaid = new HashMap<>();

        for (ExpenseUser expenseUser : allUsersExpenseForTheseExpenses) {
            User user = expenseUser.getUser();
            long currentExtraAmount = 0;
            if (moneyPaid.containsKey(user)) {
                currentExtraAmount = expenseUser.getAmount();
            }
            if (expenseUser.getExpenseUserType().equals(ExpenseUserType.PAID_BY)) {
                currentExtraAmount += expenseUser.getAmount();
                moneyPaid.put(user, currentExtraAmount);
            } else {
                currentExtraAmount -= expenseUser.getAmount();
                moneyPaid.put(user, currentExtraAmount);
            }
        }

        PriorityQueue<Pair<User, Long>> extraPaidQueue = new PriorityQueue<>(new Comparator<Pair<User, Long>>() {
            @Override
            public int compare(Pair<User, Long> o1, Pair<User, Long> o2) {
                return o1.b.compareTo(o2.b);
            }
        });

        PriorityQueue<Pair<User, Long>> lessPaidQueue = new PriorityQueue<>(new Comparator<Pair<User, Long>>() {
            @Override
            public int compare(Pair<User, Long> o1, Pair<User, Long> o2) {
                return o2.b.compareTo(o1.b);
            }
        });

        for (Map.Entry<User, Long> userAmount : moneyPaid.entrySet()) {
            if (userAmount.getValue() > 0) {
                extraPaidQueue.add(new Pair<>(userAmount.getKey(), userAmount.getValue()));
            } else {
                lessPaidQueue.add(new Pair<>(userAmount.getKey(), userAmount.getValue()));
            }
        }

        List<Transaction> transactions = new ArrayList<>();

        while (!extraPaidQueue.isEmpty()) {
            Pair<User, Long> lessPaidPair = lessPaidQueue.remove();
            Pair<User, Long> extraPaidPair = extraPaidQueue.remove();

            Transaction transaction = new Transaction();
            transaction.setPaidBy(extraPaidPair.a);
            transaction.setPaidTo(lessPaidPair.a);

            if (Math.abs(lessPaidPair.b) > extraPaidPair.b) {
                if (!(extraPaidPair.b - lessPaidPair.b == 0)) {
                    lessPaidQueue.add(new Pair<>(lessPaidPair.a, lessPaidPair.b));
                }
            } else {
                if (!(extraPaidPair.b - lessPaidPair.b == 0)) {
                    extraPaidQueue.add(new Pair<>(extraPaidPair.a, extraPaidPair.b));
                }
            }

            transactions.add(transaction);
        }

        return transactions;
    }

    public static void main(String[] args) {
        PriorityQueue<Pair<String, Integer>> test = new PriorityQueue<>(new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                return o2.b.compareTo(o1.b);
            }
        });

        test.add(new Pair<>("Ajay", 28));
        test.add(new Pair<>("Vijay", 25));
        test.add(new Pair<>("Moni", 26));

        while (test.size() > 0) {
            System.out.println(test.remove());
        }
    }
}


